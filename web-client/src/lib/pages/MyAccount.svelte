<script>
    import {currentUserId, currentUserName, loggedIn} from "../../store/session.js";
    import OrderApi from "../../api/OrderApi.js";
    import Button from "../components/Button.svelte";
    import {navigate} from "svelte-routing";
    import Order from "../components/Order.svelte";
    import Modal from "../components/Modal.svelte";

    let showModal = false;
    let modalId;

    let openModal = (id) => {
        modalId = id;
        showModal = true;
    };

    let cancelOrder = (id) => {
        // http request to update an order and mark it as CANCELLED
        console.log(`TODO patch for order ${id}`)
    }

    const api = new OrderApi();
    const logout = () => {
        loggedIn.update(_ => false);
        navigate("/", {state: {message: "Has salido de tu cuenta con éxito"}});
    }

</script>
<main>
    {#if showModal}
        <Modal orderId={modalId} onClose={()=> {showModal = false}} onConfirm={cancelOrder}/>
    {/if}
    <h1>Bienvenido {$currentUserName}</h1>
    <h2>Tus pedidos</h2>
    <section class="orders">
        {#await api.getOrders($currentUserId) then orders}
            {#each orders as order}
                <Order {...order} onCancel={openModal}/>
            {/each}
        {/await}
    </section>
    <div class="btn">
        <Button on:click={logout}>Salir</Button>
    </div>
</main>

<style>
    main {
        max-width: 900px;
        margin: 50px auto;
        display: flex;
        flex-direction: column;
    }

    .btn {
        margin-top: 40px;
        display: flex;
        flex-direction: row-reverse;
    }

    h1 {
        text-align: center;
    }
</style>