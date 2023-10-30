import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../components/HomeView.vue'
import BookSearch from '@/components/BookSearch.vue'
import AddBook from '@/components/AddBook.vue'
import UpdateBook from '@/components/UpdateBook.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },

  {
    path: '/book-update/:bookId',
    name: 'updateBook',
    component: UpdateBook,
    params: true
  },

  {
    path: '/book-add',
    name: 'addBook',
    component: AddBook
  },
  {
    path: '/book-search/:searchParam',
    name: 'bookSearch',
    component: BookSearch
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

