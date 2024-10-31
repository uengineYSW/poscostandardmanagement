<template>
    <v-card outlined>
        <v-card-title>
            DeleteDispatchRequest
        </v-card-title>

        <v-card-text>
            <Number label="DispatchRequestId" v-model="value.dispatchRequestId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteDispatchRequest"
            >
                DeleteDispatchRequest
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'DeleteDispatchRequestCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.dispatchRequestId = 0;
        },
        watch: {
        },
        methods: {
            deleteDispatchRequest() {
                this.$emit('deleteDispatchRequest', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

