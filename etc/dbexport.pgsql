--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: books; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.books (
    id bigint NOT NULL,
    isbn character varying(255),
    description character varying(255),
    photo character varying(255),
    title character varying(255),
    zone_id bigint,
    category_id bigint
);


ALTER TABLE public.books OWNER TO postgres;

--
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO postgres;

--
-- Name: books_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.books_id_seq OWNED BY public.books.id;


--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    id bigint NOT NULL,
    max_age integer,
    min_age integer,
    name character varying(255)
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_id_seq OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- Name: copies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.copies (
    id bigint NOT NULL,
    code character varying(255),
    book_id bigint
);


ALTER TABLE public.copies OWNER TO postgres;

--
-- Name: copies_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.copies_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.copies_id_seq OWNER TO postgres;

--
-- Name: copies_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.copies_id_seq OWNED BY public.copies.id;


--
-- Name: loans; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.loans (
    id bigint NOT NULL,
    date_of_entry timestamp without time zone,
    date_of_out timestamp without time zone,
    user_id bigint,
    copy_id bigint
);


ALTER TABLE public.loans OWNER TO postgres;

--
-- Name: loans_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.loans_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.loans_id_seq OWNER TO postgres;

--
-- Name: loans_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.loans_id_seq OWNED BY public.loans.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    name character varying(60)
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: user_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.user_roles OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(50),
    name character varying(50),
    password character varying(100),
    username character varying(50)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: zones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.zones (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.zones OWNER TO postgres;

--
-- Name: zones_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.zones_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.zones_id_seq OWNER TO postgres;

--
-- Name: zones_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.zones_id_seq OWNED BY public.zones.id;


--
-- Name: books id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books ALTER COLUMN id SET DEFAULT nextval('public.books_id_seq'::regclass);


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- Name: copies id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.copies ALTER COLUMN id SET DEFAULT nextval('public.copies_id_seq'::regclass);


--
-- Name: loans id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loans ALTER COLUMN id SET DEFAULT nextval('public.loans_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: zones id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zones ALTER COLUMN id SET DEFAULT nextval('public.zones_id_seq'::regclass);


--
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.books (id, isbn, description, photo, title, zone_id, category_id) FROM stdin;
1	978-1785888960	Expert techniques for building fast servers and scalable, real-time network applications with minimal effort; rewritten for Node.js 8 and Node.js 9	https://images-na.ssl-images-amazon.com/images/I/51d40-df-yL._SX404_BO1,204,203,200_.jpg	nodejs	1	2
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categories (id, max_age, min_age, name) FROM stdin;
1	12	0	infantil
2	20	12	juvenil
3	120	21	adulto
\.


--
-- Data for Name: copies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.copies (id, code, book_id) FROM stdin;
1	P001	1
2	P002	1
3	P003	1
4	P004	1
\.


--
-- Data for Name: loans; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.loans (id, date_of_entry, date_of_out, user_id, copy_id) FROM stdin;
1	2019-09-22 14:02:41.383824	\N	1	1
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, name) FROM stdin;
1	ROLE_USER
2	ROLE_PM
3	ROLE_ADMIN
\.


--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_roles (user_id, role_id) FROM stdin;
1	1
2	1
3	1
4	1
5	1
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, name, password, username) FROM stdin;
1	e.juandav@gmail.com	Juan David	$2a$10$w3sC1AgAVROCag08geFutOYD2RACg.Eru1RWB.suDa1NbRleH1bGC	juandav
2	ingenierojuand@gmail.com	Juan David Echeverry Rivera	$2a$10$aTnbtnnBRDPzij7RfPeUwurApSVtQITESIfqUZmMNa/cQVaJfoahi	juanqtx
3	juan@gmail.com	Juan David Echeverry Rivera	$2a$10$D2Wlf3a.I3RushCDpaUC5OoWR.NsXqoSHxXVvxUavjnN3V7u0pBt2	juandav2
4	e.dad@gmail.com	Juan David Echeverry Rivera	$2a$10$wVvcqwvzOYOhS9Jyem8NQ.sy7wUJDG8nqMEoz93AaJKB121QcAuBa	juandav3
5	e.juandavd78@gmail.com	Juan David Echeverry Rivera	$2a$10$oPNMaezfWGVmlid59R6RIu9XMi29qHtN70hu3FrVER5uAoTY1aHjK	juandav78
\.


--
-- Data for Name: zones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.zones (id, name) FROM stdin;
1	historico
2	cultural
3	drama
\.


--
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.books_id_seq', 1, false);


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_id_seq', 1, false);


--
-- Name: copies_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.copies_id_seq', 1, false);


--
-- Name: loans_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.loans_id_seq', 1, false);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 5, true);


--
-- Name: zones_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.zones_id_seq', 1, false);


--
-- Name: books books_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT books_pkey PRIMARY KEY (id);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: copies copies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.copies
    ADD CONSTRAINT copies_pkey PRIMARY KEY (id);


--
-- Name: loans loans_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loans
    ADD CONSTRAINT loans_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: users uk6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- Name: roles uk_nb4h0p6txrmfc0xbrd1kglp9t; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT uk_nb4h0p6txrmfc0xbrd1kglp9t UNIQUE (name);


--
-- Name: books ukbxaq6uktk0il576yf3tejym86; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT ukbxaq6uktk0il576yf3tejym86 UNIQUE (isbn);


--
-- Name: copies ukpoodmwiw6c3m5atmn21yndxke; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.copies
    ADD CONSTRAINT ukpoodmwiw6c3m5atmn21yndxke UNIQUE (code);


--
-- Name: users ukr43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- Name: user_roles user_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: zones zones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.zones
    ADD CONSTRAINT zones_pkey PRIMARY KEY (id);


--
-- Name: loans fk6xxlcjc0rqtn5nq28vjnx5t9d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loans
    ADD CONSTRAINT fk6xxlcjc0rqtn5nq28vjnx5t9d FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: user_roles fkh8ciramu9cc9q3qcqiv4ue8a6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- Name: user_roles fkhfh9dx7w3ubf1co1vdev94g3f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: copies fkic2xn1usf0mywohvy5thj1m3l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.copies
    ADD CONSTRAINT fkic2xn1usf0mywohvy5thj1m3l FOREIGN KEY (book_id) REFERENCES public.books(id);


--
-- Name: books fkleqa3hhc0uhfvurq6mil47xk0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT fkleqa3hhc0uhfvurq6mil47xk0 FOREIGN KEY (category_id) REFERENCES public.categories(id);


--
-- Name: loans fklinseuu52xb6wknrxp9ae0uwu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loans
    ADD CONSTRAINT fklinseuu52xb6wknrxp9ae0uwu FOREIGN KEY (copy_id) REFERENCES public.copies(id);


--
-- Name: books fksn69mbau023g8ce6e7p2k133v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.books
    ADD CONSTRAINT fksn69mbau023g8ce6e7p2k133v FOREIGN KEY (zone_id) REFERENCES public.zones(id);


--
-- PostgreSQL database dump complete
--

