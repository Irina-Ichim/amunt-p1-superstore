<script>
    import {currentUserId, currentUserName, loggedIn} from "../../store/session.js";
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
    <h1>Bienvenido {$currentUserName} </h1>
    <h2>Tus pedidos</h2>
    {#await api.getOrders($currentUserId) then orders}
<!--        [
{"id":"06bfb49c-d637-4e5a-bb8f-be92d936f235","address":"carrer de muntaner 137, 2-1","city":"Barcelona","country":"Spain","postalCode":"08099","products":["1e35aafe-46b0-470d-82c5-88394e4f9bcc","49ee6207-5eb1-4779-8c35-adf322ee25ab"]}]-->
        {#each orders as {id, products, shippingData, status, totalCost}}
            #{id} ({status}) with {products.length} products and a total cost of {totalCost}
        {/each}
    {/await}

    <Button on:click={logout}>Salir</Button>
</section>

