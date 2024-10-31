<template>
    <v-card outlined>
        <v-card-title>
            CreateCodeManagement
        </v-card-title>

        <v-card-text>
            <Number label="Id" v-model="value.id" :editMode="editMode"/>
            <String label="CodeCategory" v-model="value.codeCategory" :editMode="editMode"/>
            <String label="CodeCategoryName" v-model="value.codeCategoryName" :editMode="editMode"/>
            <String label="SettlementType" v-model="value.settlementType" :editMode="editMode"/>
            <String label="Remarks" v-model="value.remarks" :editMode="editMode"/>
            <CodeInfo offline label="CodeInfo" v-model="value.codeInfo" :editMode="editMode" @change="change"/>
            <CodeCategory offline label="CodeCategory" v-model="value.codeCategory" :editMode="editMode" @change="change"/>
            <Code offline label="Code" v-model="value.code" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createCodeManagement"
            >
                CreateCodeManagement
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
        name: 'CreateCodeManagementCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.id = 0;
            this.value.codeCategory = '';
            this.value.codeCategoryName = '';
            this.value.settlementType = '';
            this.value.remarks = '';
            this.value.codeInfo = {};
            this.value.codeCategory = {};
            this.value.code = {};
        },
        watch: {
        },
        methods: {
            createCodeManagement() {
                this.$emit('createCodeManagement', this.value);
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

