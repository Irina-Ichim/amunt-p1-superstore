<script>
    import {products as productsStore} from "../../store/products.js";

    export let id;
    export let address;
    export let city;
    export let country;
    export let products = [];
    $: productsInfo = products.map(id => $productsStore.find(e => e.id == id))
</script>

<article>
    <section>
        <h2>Pedido {id}</h2>
        <p>Envío: {address} - {city} ({country})</p>
    </section>
    <section>
        <h2>Productos:</h2>
        {#each productsInfo as {imageUrl, name, price}}
            <article>
                <img src={imageUrl} alt={name}/>
                <p>{name} ({price}€)</p>
            </article>
        {/each}
    </section>
</article>