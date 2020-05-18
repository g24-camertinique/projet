SET search_path TO projet;


-- Supprimer toutes les données
DELETE FROM service;
DELETE FROM concerner;
DELETE FROM memo;
DELETE FROM telephone;
DELETE FROM personne;
DELETE FROM categorie;
DELETE FROM role;
DELETE FROM compte;
DELETE FROM candidat;
DELETE FROM benevole;
DELETE FROM poste;
DELETE FROM course;
DELETE FROM equipe;
DELETE FROM categorie1;
DELETE FROM souhaiter;
DELETE FROM etre_affecte_au;
DELETE FROM document;
DELETE FROM compteA;

--nouvelles insertions

-- compteA
INSERT INTO compteA (idcompte, login, motdepasse ) VALUES 
  (1, 'pao', 'pao'),
  (2, 'soso', 'soso' ),
  (3, 'amanda', 'amanda' ),
  (4, 'chachy', 'chachy' );
  ALTER TABLE comptea ALTER COLUMN idcompte RESTART WITH 5;
  
-- candidat
INSERT INTO candidat (idcandidat, club, nom, prenom, dateden, adresse, numtelephone,
mail) VALUES 
(1, 'pao121', 'ngassie', 'sorelle','2008-04-06' , '189paris' , '05688452','sorelle@3il.fr' ),
  (2, 'pao141', 'ngassie', 'sorelle','2008-04-06' , '189paris' , '05688452','sorelle@3il.fr' );
ALTER TABLE candidat ALTER COLUMN idcandidat RESTART WITH 3;
  
-- benevoles

 INSERT INTO benevole (idbenevole, nom, prenom, dateden, adresse, numtelephone, mail, interne, disponibilite , validation , dateinscriptionb, idcompte) VALUES 
  (1,'wofa', 'paolyne','2000-01-04' , '185limoges' , '05854278','pao@3il.fr','true',' indisponible','false','2000-04-06',1 ),
   (2,'ngassie', 'sorelle','2000-02-04' , '185nice' , '05854978','wofa@3il.fr','false',' disponible','true','2000-04-07',2 );
ALTER TABLE benevole ALTER COLUMN idbenevole RESTART WITH 3;

-- poste
 
INSERT INTO poste (idposte, libelle, heuredebut, heurefin, nbrbenevoles, types) VALUES 
  (1, 'benevole externe', '11:01:32', '12:04:54',5 , 'libre'),
   (2, 'benevole interne', '11:08:32', '12:04:58',6 , 'libre');
 ALTER TABLE poste ALTER COLUMN idposte RESTART WITH 3;
  
  --  etre_affecte_au

INSERT INTO etre_affecte_au (idposte, idbenevole ) VALUES 
  (1, 2 ),
  (2, 2 );

  
  --  Document
INSERT INTO document (iddocument, libelle, idcandidat ) VALUES 
  (1, 'doc1', 1 ),
  (2, 'doc2', 2 );
 ALTER TABLE document ALTER COLUMN iddocument RESTART WITH 3;
 
  -- categorie1
  INSERT INTO categorie1 (idcategorie1, nomcategorie) VALUES 
  (1, 'categorie1'),
  (2, 'categorie2');
   ALTER TABLE categorie1 ALTER COLUMN idcategorie1 RESTART WITH 3;

  --course
   INSERT INTO course (idcourse, nom, datecourse) VALUES 
  (1, 'course1', '2014-08-04'),
  (2, 'course2', '2011-08-04');
   ALTER TABLE course ALTER COLUMN idcourse RESTART WITH 3;

 
-- equipes
INSERT INTO equipe (idequipe, nom, nbrerepas, validation, dateinscriptione, idcompte, idcourse, idcategorie1, idcandidatcap, idcandidateq) VALUES 
  (1, 'team1', 10, 'false', '2015-01-02', 1, 1, 1, 1, 2),
  (2, 'team2', 14, 'true','2017-02-05' , 3, 1,1,1,2);
   ALTER TABLE equipe ALTER COLUMN idequipe RESTART WITH 3;
  
--souhaiter
 INSERT INTO souhaiter (idposte, idbenevole) VALUES 
  (1,1 ),
  (2,2 );

  
 




  
-- Compte
INSERT INTO compte (idcompte, pseudo, motdepasse, email ) VALUES 
  (1, 'geek', 'geek', 'geek@3il.fr' ),
  (2, 'chef', 'chef', 'chef@3il.fr' ),
  (3, 'job', 'job', 'job@3il.fr' );

ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 4;


-- Role

INSERT INTO role (idcompte, role) VALUES 
  ( 1, 'ADMINISTRATEUR' ),
  ( 1, 'UTILISATEUR' ),
  ( 2, 'UTILISATEUR' ),
  ( 3, 'UTILISATEUR' );

-- Categorie
  
INSERT INTO categorie (idcategorie, libelle ) VALUES 
  (1, 'Employés' ),
  (2, 'Partenaires' ),
  (3, 'Clients' ),
  (4, 'Fournisseurs' ),
  (5, 'Dirigeants' );

ALTER TABLE categorie ALTER COLUMN idcategorie RESTART WITH 6;


-- Personne

INSERT INTO personne (idpersonne, idcategorie, nom, prenom) VALUES 
  ( 1, 1, 'GRASSET', 'Jérôme' ),
  ( 2, 1, 'BOUBY', 'Claude' ),
  ( 3, 1, 'AMBLARD', 'Emmanuel' );

ALTER TABLE personne ALTER COLUMN idpersonne RESTART WITH 4;


-- Telephone

INSERT INTO telephone (idtelephone, idpersonne, libelle, numero ) VALUES 
  ( 11, 1, 'Portable', '06 11 11 11 11' ),
  ( 12, 1, 'Fax', '05 55 99 11 11' ),
  ( 13, 1, 'Bureau', '05 55 11 11 11' ),
  ( 21, 2, 'Portable', '06 22 22 22 22' ),
  ( 22, 2, 'Fax', '05 55 99 22 22' ),
  ( 23, 2, 'Bureau', '05 55 22 22 22' ),
  ( 31, 3, 'Portable', '06 33 33 33 33' ),
  ( 32, 3, 'Fax', '05 55 99 33 33' ),
  ( 33, 3, 'Bureau', '05 55 33 33 33' );

ALTER TABLE telephone ALTER COLUMN idtelephone RESTART WITH 100;


-- Memo

INSERT INTO memo (idmemo, titre, description, flagurgent, statut, effectif, budget, echeance, idcategorie ) VALUES 
  ( 1, 'Mémo n°1', 'Texte du mémo n°1', TRUE,  2,   2,   1234.56,   {d  '2020-02-25' }, 1 ),
  ( 2, 'Mémo n°2', 'Texte du mémo n°2', FALSE, 1,   4,   5000.00,   {d  '2020-05-18' }, 2 ),
  ( 3, 'Mémo n°3', NULL, TRUE, 0, NULL, NULL, NULL, NULL );

ALTER TABLE memo ALTER COLUMN idmemo RESTART WITH 4;


-- Concerner

INSERT INTO concerner (idmemo, idPersonne) VALUES 
  ( 1, 1 ),
  ( 1, 2 ),
  ( 1, 3 ),
  ( 2, 1 ),
  ( 2, 2 );


-- Service

INSERT INTO service ( idservice, nom, anneecreation, flagsiege ) VALUES 
  ( 1, 'Direction', 2007, TRUE ),
  ( 2, 'Comptabilité', NULL, TRUE ),
  ( 3, 'Agence Limoges', 2008, FALSE ),
  ( 4, 'Agence Brive', 2014, FALSE );


ALTER TABLE service ALTER COLUMN idservice RESTART WITH 5;

