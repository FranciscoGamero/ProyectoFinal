INSERT INTO categoria_arma (id, nombre) VALUES (1, 'Pistola');
INSERT INTO categoria_arma (id, nombre) VALUES (2, 'Escopeta');
INSERT INTO categoria_accion (id, nombre) VALUES (1,'Muelle');
INSERT INTO categoria_accion (id, nombre) VALUES (2,'Eléctrica');
INSERT INTO tipo_galeria (id, nombre, precio_hora) VALUES (1,'Sin equipamiento', 10);
INSERT INTO tipo_galeria (id, nombre, precio_hora) VALUES (2,'Con equipamiento prestado', 15);
INSERT INTO tipo_galeria (id, nombre, precio_hora) VALUES (3,'Con equipamiento prestado y acompañantes', 23);

INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (1, 'Glock 17', 'Pistola totalmente automática. Útil como arma de respaldo para espacios reducidos o como un divertido tirador al blanco en casa. Esta elegante pistola Airsoft tiene un aspecto moderno y agresivo y funciona con una batería recargable, almacenada dentro de la pistola. El selector montado en la corredera ofrece un modo de disparo semiautomático o totalmente automático. Disparos divertidos para todos.','Glock', 'https://airsoftyecla.es/4379-large_default/glock-17-gen-5-we-gas-blowback.jpg',50.9);
INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (2, 'Desert eagle', 'El arma de airsoft Desert Eagle es una de esas réplicas que dan una fuerte sensación de metal. El único plástico presente en el arma es el clip, pero también es una pieza sólida de plástico ABS. Generalmente, las réplicas del airsoft del águila del desierto son absolutamente pesadas, pues se hacen casi enteramente del metal. Pero esto no impide que sean fáciles de manejar e increíblemente precisos. Además, se sabe que son relativamente silenciosos.','Magnum Research', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/DesertEagle_50AE.jpg/1200px-DesertEagle_50AE.jpg',100);
INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (3, 'Beretta M9', 'Construida en metal, esta réplica emana fuerza y se complementa con un sistema Blowback muy potente que ofrece sensaciones de juegos fuera de lo común. Es la elección del Co2 lo que permite obtener una recesión tan importante mientras se mantiene una potencia de fuego significativa','Beretta', 'https://0isznc85bj26dve98q0gl0q.blob.core.windows.net/hybris/images/700Wx700H/M9A3black_desc001.png',17986);
INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (4, 'HK USP 45 ', 'El modelo FNX 45 de este producto es conocido por su durabilidad y precisión. Este modelo ha sido diseñado para resistir las condiciones más duras, asegurando que siempre esté listo para la acción. Además, su diseño táctico le permite adaptarse a cualquier situación, lo que lo convierte en una opción ideal para los entusiastas del airsoft.','Heckler & Koch', 'https://www.mildot.es/media/catalog/product/cache/2e283216b9b8db583f30b3d56917cfe1/p/i/pistola-hk-usp-45-blowback-gbb-6mm.jpg',8797);
INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (5,'CAMISETA DE COMBATE UBAC', 'La Ubac A-Tacs FG es una camiseta de combate táctica del fabricante Invader Gear ligera, transpirable, resistente, comoda, ideal para colocar debajo de una camisa, chaleco o chaqueta mientras realizas cualquier actividad al aire libre.', 'Invader Gear', 'https://www.tssm.es/4919-thickbox_default/camiseta-de-combate-ubac-invader-gear-a-tacs-fg.jpg', 29.99);
INSERT INTO Producto (id, nombre, descripcion, marca, imagen, precio) VALUES (6, 'PANTALON COMBATE DELTA TACTICS BOSCOSO PIXELADO', 'Uniforme de combate TCU, es un uniforme diseñado para el máximo confort, con muy buenos acabados y pensado para un uso intensivo en todo tipo de situaciones. Delta Tactics es un fabricante español líder en el mercado europeo del Airsoft y la caza ya que ofrece productos con una relación calidad/precio extraordinaria. En concreto los uniformes no dejarán indiferentes a ningún usuario ya que poseen unos acabados y calidad de fabricación al máximo nivel. Una de las mejores opciones del mercado para todo tipo de usuarios.', 'DELTA TACTICS', 'https://www.zonatactica.es/4042/ropa-tactica-pantalon-de-combate-boscoso-pixelado-ejercito-espanol-delta-tactics.jpg', 49.99);

INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (1,1,2,15,true);
INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (2,1,2,7,false);
INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (3,1,2,12,false);
INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (4,1,2,9,true);
INSERT INTO equipamiento (id, talla, color) VALUES(5, 0, 'azul');
INSERT INTO equipamiento (id, talla, color) VALUES (6, 1, 'Verde');


INSERT INTO galeria (id, descripcion, imagen, tipo_id, cant_personas) VALUES (1, 'Zona de juego sin equipamiento - Perfecta para partidas de airsoft', 'https://www.brairsoft.co.uk/wp-content/uploads/2022/02/mobile-shooting-range.jpg', 1, 1);
INSERT INTO galeria (id, descripcion, imagen, tipo_id, cant_personas) VALUES (2, 'Campo de airsoft con equipamiento básico proporcionado - Diversión asegurada', 'https://eliteairsoft.ie/wp-content/uploads/2022/11/Shooting-range-min-1024x768.jpg', 2, 1);
INSERT INTO galeria (id, descripcion, imagen, tipo_id, cant_personas) VALUES (3, 'Campo de airsoft con equipamiento y personal de apoyo - Para eventos especiales', 'https://www.funarena.cz/images/AKTIVITY/Airsoft_strelnice/thumbs/fun_arena_airsoft_strelnice_1_800x800.jpg', 3, 4);


ALTER SEQUENCE categoria_arma_seq RESTART WITH 100;
ALTER SEQUENCE categoria_accion_seq RESTART WITH 100;
ALTER SEQUENCE producto_seq RESTART WITH 100;
ALTER SEQUENCE usuario_seq RESTART WITH 100;
ALTER SEQUENCE galeria_seq RESTART WITH 100;
ALTER SEQUENCE tipo_galeria_seq RESTART WITH 100;