<template>
    <div class="book-table">
        <table style="width: 80%">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Author</th>
                    <th>date</th>
                    <th>link</th>
                    <th>rating</th>

                </tr>
            </thead>
            <tbody>
                <tr class="book-item" v-for="book in books">
                    <td> {{ book.name }}</td>
                    <td>{{ book.authors[0] }}</td>
                    <td> {{ book.year }}</td>
                    <td> <a v-bind:href="book.url">link</a></td>
                    <td>{{ book.rating }}</td>

                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from 'axios';

let book = {
    name: "",
    author: '',
    url: ''
}
export default {
    name: 'bookSearch',
    data() {
        return {
                searchParam: this.$route.params.searchParam,
                books: []
            
        }
    },
    created() {
        const url = 'http://localhost:8088/api/v1/book-service/search/book/' + this.searchParam
        axios.get(url)
            .then(response => {
                this.books = response.data
            })
            .catch((e) => {
                console.error(e)
            })
    },
}

</script>
