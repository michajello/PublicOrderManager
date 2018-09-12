-- Table: public.orderer

-- DROP TABLE public.orderer;

CREATE TABLE public.orderer
(
    orderer_id bigint NOT NULL,
    zamawiajacy_email character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_fax character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_kod_poczt character varying(255) COLLATE pg_catalog."default",
    kod_pocztowy_id character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_miejscowosc character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_nazwa character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_nr_domu character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_nr_miesz character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_regon character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_rodzaj character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_rodzaj_inny character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_tel character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_ulica character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_wojewodztwo character varying(255) COLLATE pg_catalog."default",
    zamawiajacy_www character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT orderer_pkey PRIMARY KEY (orderer_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.orderer
    OWNER to project_order_manager;

-- Table: public.user_table

-- DROP TABLE public.user_table;

CREATE TABLE public.user_table
(
    id bigint NOT NULL,
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.user_table
    OWNER to project_order_manager;




CREATE TABLE public.order_table
(
    id bigint NOT NULL,
    akcept boolean,
    aukcja boolean,
    czas date,
    data_publikacji date,
    data_publikacji_zamowienia date,
    data_stop date,
    dialog boolean,
    document_type character varying(255) COLLATE pg_catalog."default",
    dsz_www character varying(255) COLLATE pg_catalog."default",
    dyn_www character varying(255) COLLATE pg_catalog."default",
    gmina_id integer,
    hash character varying(255) COLLATE pg_catalog."default",
    instytucja_id character varying(255) COLLATE pg_catalog."default",
    kod_pocztowy_id character varying(255) COLLATE pg_catalog."default",
    kryterium_kod character varying(255) COLLATE pg_catalog."default",
    liczba_czesci character varying(255) COLLATE pg_catalog."default",
    liczba_dni integer,
    liczba_dni_oferty integer,
    liczba_miesiecy smallint,
    liczba_wykonawcow integer,
    nazwa text COLLATE pg_catalog."default",
    numer_biuletynu integer,
    numer_zamowienia integer,
    oferty_czesciowe boolean,
    oferty_godz character varying(255) COLLATE pg_catalog."default",
    ogloszenie_bzp character varying(255) COLLATE pg_catalog."default",
    order_kind character varying(255) COLLATE pg_catalog."default",
    powiat_id character varying(255) COLLATE pg_catalog."default",
    pozycja character varying(255) COLLATE pg_catalog."default",
    projekt_ue text COLLATE pg_catalog."default",
    przedmiot text COLLATE pg_catalog."default",
    publikacja_obowiazkowa character varying(255) COLLATE pg_catalog."default",
    order_id_from_rest_server bigint,
    sprawozdanie_calosc boolean,
    sprawozdanie_lata_obrotowe boolean,
    status_id character varying(255) COLLATE pg_catalog."default",
    termin character varying(255) COLLATE pg_catalog."default",
    tryb_id character varying(255) COLLATE pg_catalog."default",
    tryby_id character varying(255) COLLATE pg_catalog."default",
    tryby_nazwa character varying(255) COLLATE pg_catalog."default",
    uniewaznienie boolean,
    uzupelniajace boolean,
    wariant boolean,
    wartosc_cena bigint,
    wartosc_cena_max bigint,
    wartosc_cena_min bigint,
    wartosc_szacowana bigint,
    wartosc_szacunkowa bigint,
    wojewodztwo_id character varying(255) COLLATE pg_catalog."default",
    wykonawca_str character varying(255) COLLATE pg_catalog."default",
    zaliczka boolean,
    zamowienie_ue boolean,
    zmiana_ogloszenia boolean,
    zmiana_umowy boolean,
    orderer_id bigint NOT NULL,
    CONSTRAINT order_pkey PRIMARY KEY (id),
    CONSTRAINT orderer_fkey FOREIGN KEY (orderer_id)
        REFERENCES public.orderer (orderer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.order_table
    OWNER to project_order_manager;

-- Index: rest_id_idx

-- DROP INDEX public.rest_id_idx;

CREATE INDEX rest_id_idx
    ON public.order_table USING btree
    (order_id_from_rest_server)
    TABLESPACE pg_default;


-------------------------
-- TABLE observing

CREATE TABLE public.observing
(
    user_id bigint NOT NULL,
    order_id bigint NOT NULL,
    CONSTRAINT user_order_pkey PRIMARY KEY (user_id, order_id),
    CONSTRAINT order_fkey FOREIGN KEY (order_id)
        REFERENCES public.order_table (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_fkey FOREIGN KEY (user_id)
        REFERENCES public.user_table (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.observing
    OWNER to project_order_manager;


