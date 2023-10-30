import { ref } from 'vue'
import { defineStore } from 'pinia'


export const useKeycloakStore = defineStore('keycloakStore', () => {
  const keycloak = ref()

  return { keycloak }
})