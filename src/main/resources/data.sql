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
insert into products (name, price, image_url, description_text, id)
values ('iPhone 9', 549, 'https://i.dummyjson.com/data/products/1/thumbnail.jpg', 'An apple mobile which is nothing like apple', gen_random_uuid()),
       ('iPhone X', 899, 'https://i.dummyjson.com/data/products/2/thumbnail.jpg', 'SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip with ...', gen_random_uuid()),
       ('Samsung Universe 9', 1249, 'https://i.dummyjson.com/data/products/3/thumbnail.jpg', 'Samsung new variant which goes beyond Galaxy to the Universe', gen_random_uuid()),
       ('OPPOF19', 280, 'https://i.dummyjson.com/data/products/4/thumbnail.jpg', 'OPPO F19 is officially announced on April 2021.', gen_random_uuid()),
       ('Huawei P30', 499, 'https://i.dummyjson.com/data/products/5/thumbnail.jpg', 'Huawei’s re-badged P30 Pro New Edition was officially unveiled yesterday in Germany and now the device has made its way to the UK.', gen_random_uuid()),
       ('MacBook Pro', 1749, 'https://i.dummyjson.com/data/products/6/thumbnail.png', 'MacBook Pro 2021 with mini-LED display may launch between September, November', gen_random_uuid()),
       ('Samsung Galaxy Book', 1499, 'https://i.dummyjson.com/data/products/7/thumbnail.jpg', 'Samsung Galaxy Book S (2020) Laptop With Intel Lakefield Chip, 8GB of RAM Launched', gen_random_uuid()),
       ('Microsoft Surface Laptop 4', 1499, 'https://i.dummyjson.com/data/products/8/thumbnail.jpg', 'Style and speed. Stand out on HD video calls backed by Studio Mics. Capture ideas on the vibrant touchscreen.', gen_random_uuid()),
       ('Infinix INBOOK', 1099, 'https://i.dummyjson.com/data/products/9/thumbnail.jpg', 'Infinix Inbook X1 Ci3 10th 8GB 256GB 14 Win10 Grey – 1 Year Warranty', gen_random_uuid()),
       ('HP Pavilion 15-DK1056WM', 1099, 'https://i.dummyjson.com/data/products/10/thumbnail.jpeg', 'HP Pavilion 15-DK1056WM Gaming Laptop 10th Gen Core i5, 8GB, 256GB SSD, GTX 1650 4GB, Windows 10', gen_random_uuid()),
       ('perfume Oil', 13, 'https://i.dummyjson.com/data/products/11/thumbnail.jpg', 'Mega Discount, Impression of Acqua Di Gio by GiorgioArmani concentrated attar perfume Oil', gen_random_uuid()),
       ('Brown Perfume', 40, 'https://i.dummyjson.com/data/products/12/thumbnail.jpg', 'Royal_Mirage Sport Brown Perfume for Men & Women - 120ml', gen_random_uuid()),
       ('Fog Scent Xpressio Perfume', 13, 'https://i.dummyjson.com/data/products/13/thumbnail.webp', 'Product details of Best Fog Scent Xpressio Perfume 100ml For Men cool long lasting perfumes for Men', gen_random_uuid()),
       ('Non-Alcoholic Concentrated Perfume Oil', 120, 'https://i.dummyjson.com/data/products/14/thumbnail.jpg',
        'Original Al Munakh® by Mahal Al Musk | Our Impression of Climate | 6ml Non-Alcoholic Concentrated Perfume Oil', gen_random_uuid()),
       ('Eau De Perfume Spray', 30, 'https://i.dummyjson.com/data/products/15/thumbnail.jpg', 'Genuine  Al-Rehab spray perfume from UAE', gen_random_uuid()),
       ('Hyaluronic Acid Serum', 19, 'https://i.dummyjson.com/data/products/16/thumbnail.jpg', 'LOreal Paris introduces Hyaluron Expert Replumping Serum formulated with 1.5% Hyaluronic Acid', gen_random_uuid()),
       ('Tree Oil 30ml', 12, 'https://i.dummyjson.com/data/products/17/thumbnail.jpg', 'Tea tree oil contains a number of compounds, including terpinen-4-ol, that have been shown to kill certain bacteria,', gen_random_uuid()),
       ('Oil Free Moisturizer 100ml', 40, 'https://i.dummyjson.com/data/products/18/thumbnail.jpg', 'Dermive Oil Free Moisturizer with SPF 20 is specifically formulated with ceramides, hyaluronic acid & sunscreen.', gen_random_uuid()),
       ('Skin Beauty Serum.', 46, 'https://i.dummyjson.com/data/products/19/thumbnail.jpg', 'Product name: rorec collagen hyaluronic acid white face serum riceNet weight: 15 m', gen_random_uuid()),
       ('Freckle Treatment Cream- 15gm', 70, 'https://i.dummyjson.com/data/products/20/thumbnail.jpg',
        'Fair & Clear is Pakistan only pure Freckle cream which helpsfade Freckles, Darkspots and pigments. Mercury level is 0%, so there are no side effects.', gen_random_uuid()),
       ('- Daal Masoor 500 grams', 20, 'https://i.dummyjson.com/data/products/21/thumbnail.png', 'Fine quality Branded Product Keep in a cool and dry place', gen_random_uuid()),
       ('Elbow Macaroni - 400 gm', 14, 'https://i.dummyjson.com/data/products/22/thumbnail.jpg', 'Product details of Bake Parlor Big Elbow Macaroni - 400 gm', gen_random_uuid()),
       ('Orange Essence Food Flavou', 14, 'https://i.dummyjson.com/data/products/23/thumbnail.jpg', 'Specifications of Orange Essence Food Flavour For Cakes and Baking Food Item', gen_random_uuid()),
       ('cereals muesli fruit nuts', 46, 'https://i.dummyjson.com/data/products/24/thumbnail.jpg', 'original fauji cereal muesli 250gm box pack original fauji cereals muesli fruit nuts flakes breakfast cereal break fast faujicereals cerels cerel foji fouji', gen_random_uuid()),
       ('Gulab Powder 50 Gram', 70, 'https://i.dummyjson.com/data/products/25/thumbnail.jpg', 'Dry Rose Flower Powder Gulab Powder 50 Gram • Treats Wounds', gen_random_uuid()),
       ('Plant Hanger For Home', 41, 'https://i.dummyjson.com/data/products/26/thumbnail.jpg', 'Boho Decor Plant Hanger For Home Wall Decoration Macrame Wall Hanging Shelf', gen_random_uuid()),
       ('Flying Wooden Bird', 51, 'https://i.dummyjson.com/data/products/27/thumbnail.webp', 'Package Include 6 Birds with Adhesive Tape Shape: 3D Shaped Wooden Birds Material: Wooden MDF, Laminated 3.5mm', gen_random_uuid()),
       ('3D Embellishment Art Lamp', 20, 'https://i.dummyjson.com/data/products/28/thumbnail.jpg', '3D led lamp sticker Wall sticker 3d wall art light on', gen_random_uuid()),
       ('Handcraft Chinese style', 60, 'https://i.dummyjson.com/data/products/29/thumbnail.webp', 'Handcraft Chinese style art luxury palace hotel villa mansion home decor ceramic vase with brass fruit plate', gen_random_uuid()),
       ('Key Holder', 30, 'https://i.dummyjson.com/data/products/30/thumbnail.jpg', 'Attractive DesignMetallic materialFour key hooksReliable & DurablePremium Quality', gen_random_uuid());

