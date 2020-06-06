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
--nos tables
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
   		(4, 'toto', 'toto' ),
    	(5, 'tata', 'tata' ),
     	(6, 'line', 'line' ),
      	(7, 'titi', 'titi' ),
       	(8, 'amanda1', 'amanda1' ),
       	(9, 'amanda2', 'amanda2' ),  
        (10, 'pao1', 'pao1' ),
        (11, 'pao2', 'pao2' ),
        (12, 'telephe', 'telephe' ),
        (13, 'telephe1', 'telephe1' ),
        (14, 'telephe2', 'telephe2' ),
        (15, 'charlene', 'charlene' ),
        (16, 'charlene1', 'charlene1' ),
        (17, 'charlene2', 'charlene2' ),
        (18, 'wofa', 'wofa' ),
        (19, 'wofa1', 'wofa1' ),
        (20, 'wofa2', 'wofa2' ),
        (21, 'wofa3', 'wofa3' ),
        (22, 'wofa4', 'wofa4' ),
        (23, 'amanda3', 'amanda3' ),
        (24, 'amanda4', 'amanda4' ),
        (25, 'charlene3', 'charlene3' ),
        (26, 'charlene4', 'charlene4' ),
        (27, 'telephe3', 'telephe3' ),
        (28, 'telephe4', 'telephe4' ),
        (29, 'charlene5', 'charlene5'),
        (30, 'charlene6', 'charlene6');
  
  ALTER TABLE comptea ALTER COLUMN idcompte RESTART WITH 31;
  
-- candidat
INSERT INTO candidat (idcandidat, club, nom, prenom, dateden, adresse, numtelephone,
mail) VALUES 
(1, 'club1', 'NGASSIE', 'Sorelle','2008-04-06' , '189paris' , '05688452','sorelle@3il.fr' ),
(2, 'club2', 'WOFA', 'Emilia','2008-07-06' , '189paris' , '05688452','leo@3il.fr' ),
(3, 'club1', 'CHARLENE', 'Nathalie','2008-04-06' , '179paris' , '06688452','titi@3il.fr' ),
(4, 'club1', 'AMANDA', 'Vanessa','2008-02-06' , '189paris' , '05688452','lolo@3il.fr' ),
(5, 'club3', 'LEO', 'Jennifer','2008-04-06' , '189paris' , '05688452','lili@3il.fr' ),
(6, 'club1', 'LULU', 'Emma','2008-01-06' , '189paris' , '05688452','rose@3il.fr' ),
(7, 'club1', 'ANDRE', 'Sonya','2008-04-06' , '189paris' , '05688452','marc@3il.fr' ),
(8, 'club4', 'MARC', 'Murielle','2008-01-06' , '189paris' , '05688452','heidi@3il.fr' ),
(9, 'club1', 'TITI', 'Audrey','2008-04-06' , '189paris' , '05688452','sorelle@3il.fr' ),
(10, 'club2', 'HARRIS', 'Marcelle','2008-04-06' , '189paris' , '05688452','fionna@3il.fr' ),
(11, 'club4', 'SOSO', 'Diva','2008-04-06' , '189paris' , '05688452','falonne@3il.fr' ),
(12, 'club1', 'HEIDI', 'Kelly','2008-04-06' , '189paris' , '05688452','sorelle@3il.fr' ),
(13, 'club3', 'BRANDY', 'Leila','2008-04-06' , '189paris' , '05688452','desir@3il.fr' ),
(14, 'club3', 'TELEPHE', 'Anais','2008-01-06' , '189paris' , '05688452','sorelle@3il.fr' ),
(15, 'club3', 'LINDA', 'Hilona','2008-04-07' , '189paris' , '05688452','charlene@3il.fr' ),
(16, 'club3', 'DYLAN', 'Charlene','2008-04-06' , '189paris' , '05688452','loli@3il.fr' ),
(17, 'club3', 'LIAM', 'Sophie','2008-04-06' , '189paris' , '05688452','boubounette@3il.fr' ),
(18, 'club3', 'JEROME', 'Dolly','2008-04-06' , '189paris' , '05688452','nkoah@3il.fr' ),
(19, 'club3', 'CLAUDE', 'Jenny','2008-04-06' , '189paris' , '05688452','theo@3il.fr' ),
(20, 'club3', 'CASSY', 'Kim','2008-04-06' , '189paris' , '05688452','chastin@3il.fr' );
ALTER TABLE candidat ALTER COLUMN idcandidat RESTART WITH 21;
  
-- benevoles

 INSERT INTO benevole (idbenevole, nom, prenom, dateden, adresse, numtelephone, mail, interne, disponibilite , validation , dateinscriptionb, idcompte) VALUES 
  (1,'WOFA', 'Paolyne','2000-01-02' , '185limoges' , '05854278','pao@3il.fr','true',' indisponible','false','2000-04-06',1 ),
  (2,'NGASSIE', 'Sorelle','2000-02-04' , '185nice' , '07596345','wofa@3il.fr','false',' disponible','true','2000-08-07',2 ),
  (3,'NGUENKEP', 'Charlene','2000-01-04' , '200pierrelaye' , '75942684','charlene@3il.fr','false',' indisponible','true','2000-08-08',3 ),
  (4,'DJIPDJO', 'Charlena','1992-02-04' , '18toulouse' , '85488821','charlena@3il.fr','false',' indisponible','true','2000-06-09',4 ),
  (5,'RETORY', 'Anais','2000-12-03' , '48babylone' , '63666972','anais@3il.fr','false',' indisponible','true','2000-04-10',5 ),
  (6,'TELEPHE', 'Emmanuel','1999-08-05' , '110chateauroux' , '78744521','emmanuel@3il.fr','false',' disponible','true','2000-07-11',6 ),
  (7,'DELAFENTRE', 'Matheo','2009-09-09' , '185nice' , '96369896','matheo@3il.fr','false',' indisponible','true','2000-01-25',7 ),
  (8,'DELARMOIRE', 'Pierre','1988-02-05' , '185nice' , '54141236','pierre@3il.fr','false',' disponible','true','2000-06-13',8 ),
  (9,'DUPONT', 'Aigle','1963-03-07' , '185nice' , '78959563','aigle@3il.fr','false',' disponible','true','2000-09-14',9 ),
  (10,'DUVENT', 'Lion','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',10 ),
  (11,'DAVIS', 'Didier','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',21 ),
  (12,'COURSE', 'Barlett','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',22 ),
  (13,'BOULANGER', 'Olivie','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',23 ),
  (14,'LAFONTAINE', 'Gauthier','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',24 ),
  (15,'ROUSSEL', 'Amabella','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',25 ),
  (16,'LANGLOIS', 'Neville','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',26 ),
  (17,'FREMONT', 'Parnella','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',27 ),
  (18,'MONJEAU', 'Océane','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',28 ),
  (19,'PEPIN', 'Gaetane','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',29 ),
  (20,'PIROUET', 'Arnou','2017-01-08' , '185nice' , '02014503','duvent@3il.fr','false',' indisponible','true','2000-04-22',30 );
  
 
  
ALTER TABLE benevole ALTER COLUMN idbenevole RESTART WITH 11;

-- poste
 
INSERT INTO poste (idposte, libelle, heuredebut, heurefin, nbrbenevoles, types) VALUES 
  (1, 'parking voiture velo', '07:00:00', '09:00:00', 2, 'M'),
  (2, 'remise des dossards', '07:00:00', '09:00:00', 4, 'M'),
  (3, 'signaleur', '08:30:00', '13:30:00', 37, 'M et E'),
  (4, 'ravitaillement', '09:00:00', '13:00:00', 6, 'M et E'),
  (5, 'securite sur eau', '09:00:00', '10:30:00', 6, 'M'),
  (6, 'Chronometrage', '09:30:00', '13:30:00', 3, 'M et E'),
  (7, 'moto fermeture', '09:00:00', '13:30:00', 2, 'libre'),
  (8, 'buvette', '07:00:00', '15:00:00', 5, 'libre'),
  (9, 'repas', '11:00:00', '14:00:00', 3, 'E'),
  (10, 'recuperer dossards et puces', '12:00:00', '13:30:00', 1, 'M'),
  (11, 'photographe', '07:00:00', '14:00:00', 2, 'libre');
 ALTER TABLE poste ALTER COLUMN idposte RESTART WITH 12;
  
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
  (1, 'hommes'),
  (2, 'femmes'),
  (3, 'mixtes'),
  (4, 'vae');
   ALTER TABLE categorie1 ALTER COLUMN idcategorie1 RESTART WITH 5;

  --course
   INSERT INTO course (idcourse, nom, datecourse) VALUES 
  (1, 'bol d air', '2014-08-04'),
  (2, 'mini bol d air', '2011-08-04');
   ALTER TABLE course ALTER COLUMN idcourse RESTART WITH 3;

 
-- equipes
INSERT INTO equipe (idequipe, nom, nbrerepas, validation, dateinscriptione, idcompte, idcourse, idcategorie1, idcandidatcap, idcandidateq) VALUES 
  (1, 'team1', 10, 'false', '2020-01-02', 11, 1, 2, 1, 2),
  (2, 'team2', 0, 'false','2020-02-05' , 12, 1,2,3,4),
  (3, 'team3', 5, 'true','2020-03-15' , 13, 1,3,5,6),
  (4, 'team4', 14, 'true','2020-04-25' , 14, 1,3,7,8),
  (5, 'team5', 7, 'false','2020-05-30' , 15, 1,3,9,10),
  (6, 'team6', 2, 'true','2020-02-28' , 16, 1,2,11,12),
  (7, 'team7', 4, 'false','2020-04-12' , 17, 1,3,13,14),
  (8, 'team8', 8, 'false','2020-05-23' , 18, 1,1,15,16),
  (9, 'team9', 16, 'true','2020-01-17' , 19, 1,1,17,18),
  (10, 'team10', 9, 'true','2020-03-09' , 20, 1,4,19,20);
   ALTER TABLE equipe ALTER COLUMN idequipe RESTART WITH 11;
  
--souhaiter
 INSERT INTO souhaiter (idposte, idbenevole) VALUES 
  (1,1 ),
  (2,2 );

  
 



--Anciennes insertions
  
-- Compte
INSERT INTO compte (idcompte, pseudo, motdepasse, email ) VALUES 
	(1, 'secretaire', 'secretaire', 'secretaire@3il.fr'),
  --(1, 'geek', 'geek', 'geek@3il.fr' ),
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

