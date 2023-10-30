<template>
    <div class="form-update-add">
        <form @submit.prevent="">
            <label for="Book Name">Name</label>
            <input type="text" required v-model="bookName" id="Book Name" placeholder="Book Name">
            <label for="author">Author</label>
            <input type="text" required v-model="author" id="author" placeholder="Author">
            <label for="Description">Description</label>
            <input type="text" required v-model="description" id="Description" placeholder="Description">
            <select required name="Status" v-model="status">
                <option disabled value="">Change status </option>
                <option>READING</option>
                <option>PLANNED</option>
                <option>FINISHED</option>
                <option>ABANDONED</option>
            </select>
            <select required name="Rating" v-model="rating">
                <option disabled value="">Change rating</option>
                <option>NONE</option>
                <option>TERRIBLE</option>
                <option>BAD</option>
                <option>NORMAL</option>
                <option>GOOD</option>
                <option>EXCELLENT</option>
            </select>
            <button @click="pushBook()"> Add</button>
        </form>
        
    </div>
</template>

<script>
import axios from 'axios';
import router from '@/router';
export default {
    name: 'addBook',
    data() {
        return {
                bookName : " ",
                author : " ",
                description: " ",
                status :'PLANNED',
                rating : 'NONE',
                success: null
            
        }
    },
    methods: {
        pushBook(){
            axios.post("http://localhost:8088/api/v1/book-service/book-add",{
                bookName :this.bookName,
                author : this.author,
                description: this.description,
                status : this.status,
                rating : this.rating
            })
            .then(response => {
                this.success = true
                console.log(response)
                router.push('/')
            })
            .catch((e )=> {
                console.error(e)

            })
        }
    }
}
</script>