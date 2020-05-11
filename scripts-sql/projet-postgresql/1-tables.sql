SET search_path TO projet;


-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet AUTHORIZATION projet;
GRANT ALL PRIVILEGES ON SCHEMA projet TO projet;


-- Nouvelles tables

------------------------------------------------------------
-- Table: Candidat
------------------------------------------------------------
CREATE TABLE candidat (
	idcandidat			INT				GENERATED BY DEFAULT AS IDENTITY,
	club				VARCHAR(50)	,
	nom					VARCHAR(50) NOT NULL,
	prenom				VARCHAR(50) NOT NULL,
	dateden				DATE,
	adresse 			VARCHAR(50),
	numtelephone		INT NOT NULL,
	mail 				VARCHAR(50),
	PRIMARY KEY (idcandidat)
);

------------------------------------------------------------
-- Table: Benevole
------------------------------------------------------------
CREATE TABLE benevole (
	idbenevole			INT				GENERATED BY DEFAULT AS IDENTITY,
	nom					VARCHAR(50) NOT NULL,
	prenom				VARCHAR(50) NOT NULL,
	dateden				DATE NOT NULL,
	adresse 			VARCHAR(50),
	numtelephone		INT NOT NULL,
	mail 				VARCHAR(50),
	interne             BOOLEAN ,
	disponibilité		VARCHAR(50),
	validation 			BOOLEAN,
	dateinscriptionb	DATE,
	PRIMARY KEY (idbenevole)--,
	--FOREIGN KEY (idcompte) REFERENCES compte (idcompte)
);

------------------------------------------------------------
-- Table: Poste
------------------------------------------------------------
CREATE TABLE Poste (
	idposte				INT				GENERATED BY DEFAULT AS IDENTITY,
	libelle				VARCHAR(50)  	NOT NULL,
	heuredebut 			TIME,
	heurefin			TIME,
	nbrbenevoles		INT,
	types				VARCHAR(50)  	NOT NULL,		
	PRIMARY KEY (idposte)
);

------------------------------------------------------------
-- Table: etre_affecte_au
------------------------------------------------------------
CREATE TABLE etre_affecte_au (
	idposte		INT		NOT NULL,
	idbenevole	INT		NOT NULL,
	PRIMARY KEY (idposte, idbenevole),
	FOREIGN KEY (idposte) REFERENCES poste (idposte),
	FOREIGN KEY (idbenevole) REFERENCES benevole (idbenevole)
);
------------------------------------------------------------
-- Table: Document
------------------------------------------------------------
CREATE TABLE document (
	iddocument		INT				GENERATED BY DEFAULT AS IDENTITY,
	libelle			VARCHAR(50),
	idcandidat		INT		NOT NULL,
	PRIMARY KEY (iddocument),
	FOREIGN KEY (idcandidat) REFERENCES candidat (idcandidat)
);

------------------------------------------------------------
-- Table: Categorie
------------------------------------------------------------
CREATE TABLE categorie1(
	idcategorie1    	INT				GENERATED BY DEFAULT AS IDENTITY,
	nomcategorie   		VARCHAR (50) NOT NULL  ,
	PRIMARY KEY (idcategorie1)
);


------------------------------------------------------------
-- Table: Course
------------------------------------------------------------
CREATE TABLE course(
	idcourse    	INT				GENERATED BY DEFAULT AS IDENTITY,
	nom    			VARCHAR (50) NOT NULL ,
	datecourse  	DATE  NOT NULL  ,
	PRIMARY KEY (idcourse)
);

------------------------------------------------------------
-- Table: Equipe
------------------------------------------------------------
CREATE TABLE equipe(
	idequipe                INT				GENERATED BY DEFAULT AS IDENTITY,
	nom                     VARCHAR (50) NOT NULL ,
	nbrerepas               INT  NOT NULL ,
	validation              BOOLEAN  NOT NULL ,
	dateinscriptione  		DATE  NOT NULL ,
	idcompte 				INT  NOT NULL,
	idcourse              	INT  NOT NULL,
	idcategorie          	INT  NOT NULL,
	idcandidatcap           INT  NOT NULL,
	idcandidateq            INT  NOT NULL,
	
	PRIMARY KEY (idequipe),
	FOREIGN KEY (idcategorie) REFERENCES categorie1(idcategorie1),
	FOREIGN KEY (idcourse) REFERENCES course(idcourse)
	FOREIGN KEY (idcourse) REFERENCES course(idcourse)
);

------------------------------------------------------------
-- Table: Souhaiter
------------------------------------------------------------
CREATE TABLE souhaiter (
	idposte 		INT  	NOT NULL,
	idbenevole		INT		NOT NULL,
	PRIMARY KEY (idposte, idbenevole),
	FOREIGN KEY (idposte) REFERENCES poste (idposte),
	FOREIGN KEY (idbenevole) REFERENCES benevole (idbenevole)
);


-- Anciennes tables
CREATE TABLE compte (
	idcompte		INT				GENERATED BY DEFAULT AS IDENTITY,
	pseudo			VARCHAR(25)		NOT NULL,
	motdepasse		VARCHAR(25) 	NOT NULL,
	email			VARCHAR(100)	NOT NULL,
	PRIMARY KEY (idcompte),
	UNIQUE (pseudo)
);

CREATE TABLE role (
	idcompte		INT				NOT NULL,
	role			VARCHAR(20)		NOT NULL,
	CHECK( Role IN ('ADMINISTRATEUR','UTILISATEUR') ),	
	PRIMARY KEY (idcompte, role),
	FOREIGN KEY (idcompte) REFERENCES compte (idcompte)
);

CREATE TABLE categorie (
	idcategorie		INT				GENERATED BY DEFAULT AS IDENTITY,
	libelle			VARCHAR(25)		NOT NULL,
	PRIMARY KEY (idcategorie)
);

CREATE TABLE personne (
	idpersonne		INT				GENERATED BY DEFAULT AS IDENTITY,
	idcategorie		INT				NOT NULL,
	nom				VARCHAR(25)  	NOT NULL,
	prenom			VARCHAR(25) 	NOT NULL,
	PRIMARY KEY (idpersonne),
 	FOREIGN KEY (idcategorie) REFERENCES categorie (idcategorie)
);

CREATE TABLE telephone (
	idtelephone		INT				GENERATED BY DEFAULT AS IDENTITY,
	idpersonne		INT			 	NOT NULL,
	Libelle			VARCHAR(25)		NOT NULL,
	Numero			VARCHAR(25)		NOT NULL,
	PRIMARY KEY (idtelephone),
	FOREIGN KEY (idpersonne) REFERENCES personne (idpersonne)
);

CREATE TABLE memo (	
	idmemo 			INT				GENERATED BY DEFAULT AS IDENTITY, 
	titre 			VARCHAR(50)		NOT NULL, 
	description		VARCHAR(1000), 
	flagurgent		BOOLEAN			NOT NULL, 
	statut			SMALLINT		NOT NULL	DEFAULT 0,
	effectif		INT,
	budget			DOUBLE PRECISION,
	echeance		Date,
	idcategorie		INT,
	CHECK( statut BETWEEN 0 AND 2 ),	
	PRIMARY KEY (idmemo),
 	FOREIGN KEY (idcategorie) REFERENCES categorie (idcategorie)
);

CREATE TABLE concerner (
	idmemo		INT				NOT NULL,
	idpersonne	INT				NOT NULL,
	PRIMARY KEY (idmemo, idpersonne),
	FOREIGN KEY (idmemo) REFERENCES memo (idmemo),
	FOREIGN KEY (idpersonne) REFERENCES personne (idpersonne)
);

CREATE TABLE service (	
	idservice 		INT				GENERATED BY DEFAULT AS IDENTITY, 
	nom 			VARCHAR(50)		NOT NULL, 
	description		VARCHAR(1000), 
	anneecreation	SMALLINT,
	flagsiege		BOOLEAN			NOT NULL, 
	PRIMARY KEY (idservice)
);


-- Vues

CREATE VIEW v_compte_avec_roles AS
	SELECT c.*, ARRAY_AGG( r.role ) AS roles
	FROM compte c 
	LEFT JOIN ROLE r ON c.idcompte = r.idcompte
	GROUP BY c.idcompte;