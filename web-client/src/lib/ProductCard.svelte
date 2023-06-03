<script>
    import missingProductImage from "../assets/missingProductImage.png"

    export let name;
    export let price;
    export let imageUrl = missingProductImage;
</script>

<article>
    <img src={imageUrl} alt="product image"/>
    <div>
        <p>{name}</p>
        <p>{price}€</p>
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
</style>

