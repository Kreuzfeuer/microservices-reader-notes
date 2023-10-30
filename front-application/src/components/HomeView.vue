<template>
    <div class="book-table">
        <div class="searchField">
            <label for="search field">Search book</label>
            <input type="text" v-model="searchParam" id="search field" placeholder="Book title or author's name">
            <RouterLink :to="{ path: '/book-search/' + searchParam }"><Button>Search</Button></RouterLink>
        </div>
        <table style="width: 70%">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Description</th>
                    <th>Status</th>
                    <th>Rating</th>
                    <th>
                        <RouterLink :to="{ path: '/book-add' }"><button>Add new book</button> </RouterLink>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr class="book-item" v-for="book in books">
                    <td> {{ book.dateAdded }}</td>
                    <td>{{ book.bookName }}</td>
                    <td> {{ book.author }}</td>
                    <td>{{ book.description }}</td>
                    <td>{{ book.status }}</td>
                    <td>{{ book.rating }}</td>
                    <td>
                        <RouterLink :to="{ path: '/book-update/' + book.id }"><Button>Book-update</Button></RouterLink>
                    </td>
                    <td><button @click="deleteBook(book.id)">Delete book</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import router from '@/router';
import axios from 'axios';

export default {
    name: 'HomeView',
    data() {
        return {
            searchParam: '',
            books: [],

            errors: []
        }
    },
    created() {
        axios.get('http://localhost:8088/api/v1/book-service/')
            .then(response => {
                this.books = response.data
            })
            .catch((e) => {
                console.error(e)
            })
    },
    methods: {
        deleteBook(id) {
            axios.delete('http://localhost:8088/api/v1/book-service/book-delete/' + id)
                .then(response => {
                    console.log(response)
                    router.go()
                })
                .catch((e) => {
                    console.error(e)
                })
        }
    }
}
</script>

<style>
table,
th,
td {
    border: 1px solid black;
}
</style>