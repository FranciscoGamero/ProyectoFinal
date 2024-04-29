insert into CategoriArma (id, nombre) values (1, "Pistola");
insert into CategoriaPropulsion (id, nombre) values (2, "Muelle");
insert into Arma (id, nombre, descripcion, imagen, precio, categoriaarma, categoriapropulsion,capacidadcargador, necesitalicencia) 
values (NEXTVALUE(arma_seq), 'Glock 17', 'P1', 'https://airsoftyecla.es/4379-large_default/glock-17-gen-5-we-gas-blowback.jpg',1,2,15,false);
insert into Arma (id, nombre, descripcion, imagen, precio, categoriaarma, categoriapropulsion,capacidadcargador, necesitalicencia) 
values (NEXTVALUE(arma_seq), 'Desert eagle', 'P2', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/DesertEagle_50AE.jpg/1200px-DesertEagle_50AE.jpg',
1,2,7,false);
insert into Arma (id, nombre, descripcion, imagen, precio, categoriaarma, categoriapropulsion,capacidadcargador, necesitalicencia) 
values (NEXTVALUE(arma_seq), 'Beretta M9', 'P3', 'https://0isznc85bj26dve98q0gl0q.blob.core.windows.net/hybris/images/700Wx700H/M9A3black_desc001.png',
1,2,12,false);
insert into Arma (id, nombre, descripcion, imagen, precio, categoriaarma, categoriapropulsion,capacidadcargador, necesitalicencia) 
values (NEXTVALUE(arma_seq), 'HK USP 45 ', 'P1', 'https://www.mildot.es/media/catalog/product/cache/2e283216b9b8db583f30b3d56917cfe1/p/i/pistola-hk-usp-45-blowback-gbb-6mm.jpg',
1,2,9,false);
