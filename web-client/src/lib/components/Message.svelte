<script>
    import { fade } from 'svelte/transition';
</script>
<div in:fade out:fade>
    <slot/>
</div>

<style>
    div {
        color: #ffa500;
        font-size: 28px;
        font-weight: bold;
        text-align: right;
        padding: 59px;
        margin-left: 20px;
    }
</style>