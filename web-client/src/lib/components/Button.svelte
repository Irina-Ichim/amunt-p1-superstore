<script>
    export let orange;
</script>

<div on:click class:orange>
    <slot/>
</div>

<style>
    div {
        border-radius: 3px;
        border: 1px solid #0B3333;
        width: 150px;
        text-align: center;
        padding: 15px;
        display: inline-block;
        cursor: pointer;
    }

    div.orange {
        background-color: #0B3333;
        color: white;
    }

</style>