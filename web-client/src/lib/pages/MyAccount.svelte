<script>
    import {currentUser, loggedIn} from "../../store/session.js";
    import OrderApi from "../../api/OrderApi.js";
    import Button from "../components/Button.svelte";
    import {navigate} from "svelte-routing";

    const api = new OrderApi();
    const logout = () => {
        loggedIn.update(_ => false);
        navigate("/", {state: {message: "Has salido de tu cuenta con éxito"}});
    }
</script>
<section>
    <h1>Bienvenido {$currentUser.name} </h1>
    <h2>Tus pedidos</h2>
    {#await api.getOrders() then orders}
        {#each orders as {id, products, shippingData, status, totalCost}}
            #{id} ({status}) with {products.length} products and a total cost of {totalCost}
        {/each}
    {/await}

    <Button on:click={logout}>Salir</Button>
</section>

