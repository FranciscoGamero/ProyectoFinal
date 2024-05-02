INSERT INTO categoria_arma (id, nombre) VALUES (1, 'Pistola');
INSERT INTO categoria_accion (id, nombre) VALUES (2,'Muelle');

INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (1, 'Glock 17', 'Pistola totalmente automática. Útil como arma de respaldo para espacios reducidos o como un divertido tirador al blanco en casa. Esta elegante pistola Airsoft tiene un aspecto moderno y agresivo y funciona con una batería recargable, almacenada dentro de la pistola. El selector montado en la corredera ofrece un modo de disparo semiautomático o totalmente automático. Disparos divertidos para todos.','Glock', 'https://airsoftyecla.es/4379-large_default/glock-17-gen-5-we-gas-blowback.jpg',50.9);
INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (2, 'Desert eagle', 'El arma de airsoft Desert Eagle es una de esas réplicas que dan una fuerte sensación de metal. El único plástico presente en el arma es el clip, pero también es una pieza sólida de plástico ABS. Generalmente, las réplicas del airsoft del águila del desierto son absolutamente pesadas, pues se hacen casi enteramente del metal. Pero esto no impide que sean fáciles de manejar e increíblemente precisos. Además, se sabe que son relativamente silenciosos.','Magnum Research', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/DesertEagle_50AE.jpg/1200px-DesertEagle_50AE.jpg',100);
INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (3, 'Beretta M9', 'Construida en metal, esta réplica emana fuerza y se complementa con un sistema Blowback muy potente que ofrece sensaciones de juegos fuera de lo común. Es la elección del Co2 lo que permite obtener una recesión tan importante mientras se mantiene una potencia de fuego significativa','Beretta', 'https://0isznc85bj26dve98q0gl0q.blob.core.windows.net/hybris/images/700Wx700H/M9A3black_desc001.png',17986);
INSERT INTO producto (id, nombre, descripcion, marca, imagen, precio) VALUES (4, 'HK USP 45 ', 'El modelo FNX 45 de este producto es conocido por su durabilidad y precisión. Este modelo ha sido diseñado para resistir las condiciones más duras, asegurando que siempre esté listo para la acción. Además, su diseño táctico le permite adaptarse a cualquier situación, lo que lo convierte en una opción ideal para los entusiastas del airsoft.','Heckler & Koch', 'https://www.mildot.es/media/catalog/product/cache/2e283216b9b8db583f30b3d56917cfe1/p/i/pistola-hk-usp-45-blowback-gbb-6mm.jpg',8797);

INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (1,1,2,15,false);
INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (2,1,2,7,false);
INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (3,1,2,12,false);
INSERT INTO arma(id,categoria_arma_id, forma_disparo_id,capacidad_cargador, necesita_licencia) VALUES (4,1,2,9,false);

INSERT INTO Usuario (id, nombre, apellidos, dni, direccion_facturacion, correo, contrasenia, admin, usuario_premium) VALUES (1, 'Juan', 'García López', '12345678A', 'Calle Mayor 123', 'juan@gmail.com', 'contraseña123', 0, 0);
INSERT INTO Usuario (id, nombre, apellidos, dni, direccion_facturacion, correo, contrasenia, admin, usuario_premium) VALUES (2, 'María', 'Martínez Rodríguez', '87654321B', 'Avenida Libertad 45', 'maria@hotmail.com', 'clave456', 1, 1);
INSERT INTO Usuario (id, nombre, apellidos, dni, direccion_facturacion, correo, contrasenia, admin, usuario_premium) VALUES (3, 'Antonio', 'Fernández Pérez', '13579246C', 'Plaza España 7', 'antonio@yahoo.com', 'p4ssw0rd', 0, 1);
INSERT INTO Usuario (id, nombre, apellidos, dni, direccion_facturacion, correo, contrasenia, admin, usuario_premium) VALUES (4, 'Sofía', 'López García', '24681357D', 'Calle Gran Vía 89', 'sofia@gmail.com', 'abc123', 0, 0);
INSERT INTO Usuario (id, nombre, apellidos, dni, direccion_facturacion, correo, contrasenia, admin, usuario_premium) VALUES (5, 'Manuel', 'González Martínez', '98765432E', 'Calle Sol 21', 'manuel@gmail.com', 'qwerty', 0, 1);


ALTER SEQUENCE categoria_arma_seq RESTART WITH 100;
ALTER SEQUENCE categoria_accion_seq RESTART WITH 100;
ALTER SEQUENCE producto_seq RESTART WITH 100;
ALTER SEQUENCE usuario_seq RESTART WITH 100;