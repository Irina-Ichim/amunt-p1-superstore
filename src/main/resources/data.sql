-- customers
do '
    declare
        shipping_id uuid = gen_random_uuid();
    begin
        insert into shipping_info (id, address, city, country, postal_code)
        values (shipping_id, ''carrer de muntaner 137, 2-1'', ''Barcelona'', ''Spain'', ''08099'');
        insert into customers (id, shipping_info_id, email, name, nif, password)
        values (gen_random_uuid(), shipping_id, ''user@superstore.com'', ''pepita'', ''45376589T'', ''password'');
    end
';

-- products
insert into products (name, price, image_url, id)
values ('iPhone 9', 549, 'https://i.dummyjson.com/data/products/1/thumbnail.jpg', gen_random_uuid()),
       ('iPhone X', 899, 'https://i.dummyjson.com/data/products/2/thumbnail.jpg', gen_random_uuid()),
       ('Samsung Universe 9', 1249, 'https://i.dummyjson.com/data/products/3/thumbnail.jpg', gen_random_uuid()),
       ('OPPOF19', 280, 'https://i.dummyjson.com/data/products/4/thumbnail.jpg', gen_random_uuid()),
       ('Huawei P30', 499, 'https://i.dummyjson.com/data/products/5/thumbnail.jpg', gen_random_uuid()),
       ('MacBook Pro', 1749, 'https://i.dummyjson.com/data/products/6/thumbnail.png', gen_random_uuid()),
       ('Samsung Galaxy Book', 1499, 'https://i.dummyjson.com/data/products/7/thumbnail.jpg', gen_random_uuid()),
       ('Microsoft Surface Laptop 4', 1499, 'https://i.dummyjson.com/data/products/8/thumbnail.jpg', gen_random_uuid()),
       ('Infinix INBOOK', 1099, 'https://i.dummyjson.com/data/products/9/thumbnail.jpg', gen_random_uuid()),
       ('HP Pavilion 15-DK1056WM', 1099, 'https://i.dummyjson.com/data/products/10/thumbnail.jpeg', gen_random_uuid()),
       ('perfume Oil', 13, 'https://i.dummyjson.com/data/products/11/thumbnail.jpg', gen_random_uuid()),
       ('Brown Perfume', 40, 'https://i.dummyjson.com/data/products/12/thumbnail.jpg', gen_random_uuid()),
       ('Fog Scent Xpressio Perfume', 13, 'https://i.dummyjson.com/data/products/13/thumbnail.webp', gen_random_uuid()),
       ('Non-Alcoholic Concentrated Perfume Oil', 120, 'https://i.dummyjson.com/data/products/14/thumbnail.jpg',
        gen_random_uuid()),
       ('Eau De Perfume Spray', 30, 'https://i.dummyjson.com/data/products/15/thumbnail.jpg', gen_random_uuid()),
       ('Hyaluronic Acid Serum', 19, 'https://i.dummyjson.com/data/products/16/thumbnail.jpg', gen_random_uuid()),
       ('Tree Oil 30ml', 12, 'https://i.dummyjson.com/data/products/17/thumbnail.jpg', gen_random_uuid()),
       ('Oil Free Moisturizer 100ml', 40, 'https://i.dummyjson.com/data/products/18/thumbnail.jpg', gen_random_uuid()),
       ('Skin Beauty Serum.', 46, 'https://i.dummyjson.com/data/products/19/thumbnail.jpg', gen_random_uuid()),
       ('Freckle Treatment Cream- 15gm', 70, 'https://i.dummyjson.com/data/products/20/thumbnail.jpg',
        gen_random_uuid()),
       ('- Daal Masoor 500 grams', 20, 'https://i.dummyjson.com/data/products/21/thumbnail.png', gen_random_uuid()),
       ('Elbow Macaroni - 400 gm', 14, 'https://i.dummyjson.com/data/products/22/thumbnail.jpg', gen_random_uuid()),
       ('Orange Essence Food Flavou', 14, 'https://i.dummyjson.com/data/products/23/thumbnail.jpg', gen_random_uuid()),
       ('cereals muesli fruit nuts', 46, 'https://i.dummyjson.com/data/products/24/thumbnail.jpg', gen_random_uuid()),
       ('Gulab Powder 50 Gram', 70, 'https://i.dummyjson.com/data/products/25/thumbnail.jpg', gen_random_uuid()),
       ('Plant Hanger For Home', 41, 'https://i.dummyjson.com/data/products/26/thumbnail.jpg', gen_random_uuid()),
       ('Flying Wooden Bird', 51, 'https://i.dummyjson.com/data/products/27/thumbnail.webp', gen_random_uuid()),
       ('3D Embellishment Art Lamp', 20, 'https://i.dummyjson.com/data/products/28/thumbnail.jpg', gen_random_uuid()),
       ('Handcraft Chinese style', 60, 'https://i.dummyjson.com/data/products/29/thumbnail.webp', gen_random_uuid()),
       ('Key Holder', 30, 'https://i.dummyjson.com/data/products/30/thumbnail.jpg', gen_random_uuid());

