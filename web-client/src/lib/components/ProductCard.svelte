<script>
    import missingProductImage from "../../assets/missingProductImage.png"
    import {navigate} from "svelte-routing";

    export let id;
    export let name;
    export let price;
    export let discountPrice;
    export let imageUrl = missingProductImage;
    let handleClick = () => {
        navigate(`/products/${id}`);
    }
</script>

<article on:click={handleClick}>
    {#if discountPrice}
        <div class="oferta">Ofertón</div>
    {/if}
    <img src={imageUrl} alt="product image"/>
    <div>
        <p>{name}</p>
        {#if discountPrice}
            <span><del>{price}€<br></del>{discountPrice}€</span>
        {:else}
            <span>{price}€</span>
        {/if}
    </div>

</article>

<style>
    article {
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        background-color: white;
        width: 250px;
        height: 300px;
        border-radius: 5px;
        cursor: pointer;
        -webkit-box-shadow: -1px 1px 5px 0 #727171;
        -moz-box-shadow: -1px 1px 5px 0 #727171FF;
        box-shadow: -1px 1px 5px 0 #727171FF;
    }

    article:hover {
        transform: translate(2px, 2px);
    }

    img {
        width: 100%;
        height: 70%;
        object-fit: cover;
        overflow: hidden;
    }

    div {
        padding: 15px;
    }

    .oferta {
        background-color: #54d754;
    }
</style>

