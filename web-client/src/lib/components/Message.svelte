<script>
    import {fade} from 'svelte/transition';
</script>
<div in:fade>
    <slot/>
</div>

<style>
    div {
        position: absolute;
        right: 0;
        font-size: large;
        width: 250px;
        border: 1px solid #0B3333;
        color: white;
        background-color: #0B3333;
        font-weight: bold;
        padding: 10px;
        text-align: center;
        z-index: 9999;
    }
</style>


