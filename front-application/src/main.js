import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import Keycloak from 'keycloak-js'
import axios from 'axios'
import { useKeycloakStore } from '@/stores/keycloakStore';
import { createPinia } from 'pinia';

const app = createApp(App).use(createPinia()).use(router)

const keycloakConfig = {
    url: process.env.VUE_APP_KEYCLOAK_URL,
    realm: process.env.VUE_APP_KEYCLOAK_REALM,
    clientId: process.env.VUE_APP_KEYCLOAK_CLIENT_ID
}
const initOptions = {
    onLoad: 'login-required',
    flow: 'standard',
    pkceMethod: 'S256',
    checkLoginIframe: false,
}
let keycloak = new Keycloak(keycloakConfig)
const keycloakStore = useKeycloakStore()
keycloakStore.keycloak = keycloak
console.log(keycloakConfig)
keycloak.init(initOptions).then(auth => {
    if (!auth) {
        console.warn("Authentication failed")
    } else {
        console.log('Authenticated')
        app.mount('#app')
    }
    setInterval(() => {
        keycloak.updateToken(70).then((refreshed) => {
            if (refreshed) {
                console.log('Token refreshed')
            } else {
                console.warn('Token not refreshed')
            }
        }).catch(() => {
            console.error('Failed to refresh token');
        });
    }, 6000)
}).catch((e) =>{
 console.error(e);
 console.error("Authentication failed")
});


axios.interceptors.request.use( async config => {
    const token = await useKeycloakStore().keycloak?.token
    config.headers['Authorization'] = `Bearer ${token}`
    config.headers['Access-Control-Allow-Origin'] = '*'
    console.log(token)
    return config
})

axios.interceptors.response.use( (response) => {
    return response
  })