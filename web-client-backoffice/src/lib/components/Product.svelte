<script>
    // {"name":"iPhone 9",
    // "price":549.0,
    // "imageUrl":"https://i.dummyjson.com/data/products/1/thumbnail.jpg",
    // "description":"An apple mobile which is nothing like apple","id":"cbc57fea-b5c9-48b2-a65b-41ff6a946ced"}
    export let info;
</script>
<div>
    <img src="{info.imageUrl}">
    <h4>{info.name}</h4>
    <h4>{info.price}€</h4>
    <section>
        <p>{info.description}</p>
    </section>
</div>

<style>

    div {
        display: flex;
        justify-content: space-between;
        flex-direction: row;
        padding: 15px;
        border: 1px solid black;
        align-items: center;
        background-color: darkgrey;
    }

    h4 {
        color: white;

    }

    img {
        width: 130px;
        height: 100px;
    }

    .p section {
        color: white;
        padding-bottom: 5px;
        align-items: center;
    }

    p {
        font-size: 20px;
    }

    section {
        width: 540px;
        height: 100px;

    }

</style>