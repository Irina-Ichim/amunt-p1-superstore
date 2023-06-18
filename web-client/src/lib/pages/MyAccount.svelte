<script>
    import {currentUserId, currentUserName, loggedIn} from "../../store/session.js";
    import OrderApi from "../../api/OrderApi.js";
    import Button from "../components/Button.svelte";
    import {navigate} from "svelte-routing";
    import Order from "../components/Order.svelte";

    const api = new OrderApi();
    const logout = () => {
        loggedIn.update(_ => false);
        navigate("/", {state: {message: "Has salido de tu cuenta con éxito"}});
    }
</script>
<main>
    <h1>Bienvenido {$currentUserName}</h1>

    <h2>Tus pedidos</h2>
    <section class="orders">
    {#await api.getOrders($currentUserId) then orders}
        {#each orders as order}
            <Order {...order}/>
        {/each}
    {/await}
    </section>
    <Button on:click={logout}>Salir</Button>
</main>

<style>
    main {
        max-width: 500px;
        margin: 50px auto;
    }
</style>