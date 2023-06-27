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
        width: 100%;
        height: 100vh;

        background-color: #353535;
        position: absolute;
        top: 0;
        left: 0;

        display: flex;
        align-items: center;
        justify-content: center;
        padding: 40px;
        flex-direction: column;
        color: white;
        font-size: 30px;
        text-align: center;
    }
</style>