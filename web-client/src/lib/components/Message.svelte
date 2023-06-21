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
        border: 1px solid #ffa500;
        color: #ffa500;
        background-color: #fff6bb;
        font-weight: bold;
        padding: 10px;
        text-align: center;
        z-index: 9999;
    }
</style>


