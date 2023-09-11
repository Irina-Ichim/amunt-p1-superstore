<script>
    export let onClose;
    export let onConfirm;
    export let orderId;
</script>


<div class="modal">
    <div>
        <p>¿Está seguro de que desea cancelar el pedido {orderId}?</p>
        <button on:click={() => onConfirm(orderId)}>Confirmar</button>
        <button on:click={onClose}>Cerrar</button>
    </div>
</div>


<style>
    .modal {
        width: 30%;
        height: 30vh;
        margin-left: 20%;
        background-color: #353535;
        position: absolute;
        top: 20px;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 20px;
        flex-direction: column;
        color: white;
        font-size: 20px;
        text-align: center;
    }
</style>