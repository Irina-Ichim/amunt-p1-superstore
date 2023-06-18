import {developmentModeOn} from "./developmentMode.js";
import {fakeFetch} from "./fakeApi/fakeFetch.js";
import fakeResponse from '../assets/fakeResponses/get_api_products.json';

export class ProductApi {
    getAllProducts() {
        return developmentModeOn ?
            fakeFetch(fakeResponse) :
            fetch("/api/products")
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Unable to get products. An error occurred");
                    }
                    return response.json();
                })
    }
}