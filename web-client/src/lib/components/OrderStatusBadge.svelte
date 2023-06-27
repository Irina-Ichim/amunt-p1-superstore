<script>
    export let orderStatus;
    let text = (status) => {
        if (status === "PENDING") {
            return "🚚 En camino"
        }
        if (status === "CANCELLED") {
            return "Cancelado!"
        }
        return "SIN ESTADO"
    }
</script>

<span>
    {text(orderStatus)}
</span>

<style>
    span {
        background-color: #aed5f6;
        padding: 0.2em;
        border-radius: 3px;
    }
</style>