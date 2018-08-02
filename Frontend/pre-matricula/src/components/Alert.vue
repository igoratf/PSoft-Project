 <template>
    <section id="alert">
        <div class="container alert alert-success alert-dismissible fade show" v-if="showSuccess" role="alert">
            {{successMessage}}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        
        <div class="container alert alert-danger alert-dismissible fade show" v-if="showError" role="alert">
            {{errorMessage}}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </section>

</template>

<script>

export default {
  name: "alert",
  created () {
  },
  props: ['successMessage', 'errorMessage', 'showSuccess', 'showError']
};
</script>
