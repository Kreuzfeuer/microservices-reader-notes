<template>
    <div class="form-update-add">
        <form @submit.prevent="">
            <label for="Book Name">Name</label>
            <input type="text" v-model="book.bookName" id="Book Name" placeholder="book.bookName">
            <label for="author">Author</label>
            <input type="text" v-model="book.author" id="author" placeholder="book.author">
            <label for="Description">Description</label>
            <input type="text" v-model="book.description" id="Description" placeholder="book.description">
            <select name="Status" v-model="book.status">
                <option disabled value="">Past status - {{ book.status }}</option>
                <option>READING</option>
                <option>PLANNED</option>
                <option>FINISHED</option>
                <option>ABANDONED</option>
            </select>
            <select name="Rating" v-model="book.rating">
                <option disabled value="">Past rating - {{ book.rating }}</option>
                <option>NONE</option>
                <option>TERRIBLE</option>
                <option>BAD</option>
                <option>NORMAL</option>
                <option>GOOD</option>
                <option>EXCELLENT</option>
            </select>
            <button @click="pushBook()"> Update</button>

        </form>
    </div>
</template>

<script >
import router from '@/router';
import axios from 'axios';

export default {
    name: 'updateBook',
    data() {
        return {
            book:{
                bookName : " ",
                author : " ",
                description: " ",
                status :'PLANNED',
                rating : 'NONE',
                success: null
            },
            bookId: this.$route.params.bookId
        }
    },
    created() {
        const url = "http://localhost:8088/api/v1/book-service/" + this.bookId
        axios.get(url)
            .then(response => {
                this.book = response.data
                console.log(response)
            })
            .catch((e)=> {
                console.error(e)
            })
    },
    methods: {
        pushBook(){
            const url = "http://localhost:8088/api/v1/book-service/book-update/" + this.bookId
            axios.put(url, {
                bookName :this.book.bookName,
                author : this.book.author,
                description: this.book.description,
                status : this.book.status,
                rating : this.book.rating
            })
            .then(response => {
                console.log(response)
                this.success = true
                router.push('/')
            })
            .catch((e)=> {
                console.error(e)
            })
        }
    }
}
</script>