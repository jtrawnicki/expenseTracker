insert into categories (id, name) values
        (gen_random_uuid(), 'Mieszkanie'),
        (gen_random_uuid(), 'Zakupy'),
        (gen_random_uuid(), 'Zdrowie'),
        (gen_random_uuid(), 'Hobby'),
        (gen_random_uuid(), 'Samochód'),
        (gen_random_uuid(), 'Zachcianki');

insert into expenses (id, name, value, category_id) values
        (gen_random_uuid(), 'Czynsz', 690, (SELECT id from categories WHERE name = 'Mieszkanie')),
        (gen_random_uuid(), 'Internet', 45, (SELECT id from categories WHERE name = 'Mieszkanie')),
        (gen_random_uuid(), 'Media', 260, (SELECT id from categories WHERE name = 'Mieszkanie'));


