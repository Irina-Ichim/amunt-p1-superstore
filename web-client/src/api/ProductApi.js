import fakeData from "../assets/fakeData.json";

let developmentModeOn = process.env.NODE_ENV === "development";

function fakeFetch() {
    return Promise.resolve(fakeData);
}

export class ProductApi {
    getAllProducts() {
        return developmentModeOn ? fakeFetch() : fetch("/api/products")
            .then(response => {
                console.log(response.ok)
                if (!response.ok) {
                    throw new Error("Unable to get products. An error occurred");
                }
                return response.json();
            })
    }
}