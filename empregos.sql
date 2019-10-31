PGDMP         
            	    w            empregos    11.5    11.5 P    i           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            j           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            k           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            l           1262    24671    empregos    DATABASE     �   CREATE DATABASE empregos WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE empregos;
             postgres    false            �            1259    24819    bairros    TABLE     �   CREATE TABLE public.bairros (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    id_cidade integer NOT NULL,
    data_exclusao date
);
    DROP TABLE public.bairros;
       public         postgres    false            �            1259    24817    bairros_id_seq    SEQUENCE     �   CREATE SEQUENCE public.bairros_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.bairros_id_seq;
       public       postgres    false    200            m           0    0    bairros_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.bairros_id_seq OWNED BY public.bairros.id;
            public       postgres    false    199            �            1259    24881    cargo_empresa    TABLE     �   CREATE TABLE public.cargo_empresa (
    id integer NOT NULL,
    id_cargo integer NOT NULL,
    id_empresa integer NOT NULL,
    data_exclusao date
);
 !   DROP TABLE public.cargo_empresa;
       public         postgres    false            �            1259    24879    cargo_empresa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cargo_empresa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cargo_empresa_id_seq;
       public       postgres    false    210            n           0    0    cargo_empresa_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cargo_empresa_id_seq OWNED BY public.cargo_empresa.id;
            public       postgres    false    209            �            1259    24863    cargos    TABLE     y   CREATE TABLE public.cargos (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    data_exclusao date
);
    DROP TABLE public.cargos;
       public         postgres    false            �            1259    24861    cargos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cargos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.cargos_id_seq;
       public       postgres    false    206            o           0    0    cargos_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.cargos_id_seq OWNED BY public.cargos.id;
            public       postgres    false    205            �            1259    24806    cidades    TABLE     �   CREATE TABLE public.cidades (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    uf_estados character varying(2) NOT NULL,
    data_exclusao date
);
    DROP TABLE public.cidades;
       public         postgres    false            �            1259    24804    cidades_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cidades_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cidades_id_seq;
       public       postgres    false    198            p           0    0    cidades_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cidades_id_seq OWNED BY public.cidades.id;
            public       postgres    false    197            �            1259    24871    empresas    TABLE     �   CREATE TABLE public.empresas (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    cnpj character varying(14) NOT NULL,
    data_exclusao date
);
    DROP TABLE public.empresas;
       public         postgres    false            �            1259    24869    empresas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.empresas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.empresas_id_seq;
       public       postgres    false    208            q           0    0    empresas_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.empresas_id_seq OWNED BY public.empresas.id;
            public       postgres    false    207            �            1259    24832    escolaridades    TABLE     �   CREATE TABLE public.escolaridades (
    id integer NOT NULL,
    escolaridade character varying(50) NOT NULL,
    data_exclusao character varying
);
 !   DROP TABLE public.escolaridades;
       public         postgres    false            �            1259    24830    escolaridades_id_seq    SEQUENCE     �   CREATE SEQUENCE public.escolaridades_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.escolaridades_id_seq;
       public       postgres    false    202            r           0    0    escolaridades_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.escolaridades_id_seq OWNED BY public.escolaridades.id;
            public       postgres    false    201            �            1259    24799    estados    TABLE     o   CREATE TABLE public.estados (
    uf character varying(2) NOT NULL,
    nome character varying(50) NOT NULL
);
    DROP TABLE public.estados;
       public         postgres    false            �            1259    24843    pessoas    TABLE     9  CREATE TABLE public.pessoas (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    cpf character varying(11) NOT NULL,
    data_nascimento date NOT NULL,
    telefone character varying(12) NOT NULL,
    id_bairro integer NOT NULL,
    id_escolaridade integer NOT NULL,
    data_exclusao date
);
    DROP TABLE public.pessoas;
       public         postgres    false            �            1259    24841    pessoas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pessoas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.pessoas_id_seq;
       public       postgres    false    204            s           0    0    pessoas_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.pessoas_id_seq OWNED BY public.pessoas.id;
            public       postgres    false    203            �            1259    24899    pessoas_vagas    TABLE     �   CREATE TABLE public.pessoas_vagas (
    id integer NOT NULL,
    id_pessoa integer NOT NULL,
    id_cargo_empresa integer NOT NULL,
    data_exclusao date
);
 !   DROP TABLE public.pessoas_vagas;
       public         postgres    false            �            1259    24897    pessoas_vagas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pessoas_vagas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.pessoas_vagas_id_seq;
       public       postgres    false    212            t           0    0    pessoas_vagas_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.pessoas_vagas_id_seq OWNED BY public.pessoas_vagas.id;
            public       postgres    false    211            �            1259    24917    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    id integer NOT NULL,
    login character varying(50) NOT NULL,
    nome character varying(50) NOT NULL,
    senha character varying(50) NOT NULL,
    nivel character varying(1) NOT NULL
);
    DROP TABLE public.usuarios;
       public         postgres    false            �            1259    24915    usuarios_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.usuarios_id_seq;
       public       postgres    false    214            u           0    0    usuarios_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.usuarios_id_seq OWNED BY public.usuarios.id;
            public       postgres    false    213            �
           2604    24822 
   bairros id    DEFAULT     h   ALTER TABLE ONLY public.bairros ALTER COLUMN id SET DEFAULT nextval('public.bairros_id_seq'::regclass);
 9   ALTER TABLE public.bairros ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    200    200            �
           2604    24884    cargo_empresa id    DEFAULT     t   ALTER TABLE ONLY public.cargo_empresa ALTER COLUMN id SET DEFAULT nextval('public.cargo_empresa_id_seq'::regclass);
 ?   ALTER TABLE public.cargo_empresa ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    210    209    210            �
           2604    24866 	   cargos id    DEFAULT     f   ALTER TABLE ONLY public.cargos ALTER COLUMN id SET DEFAULT nextval('public.cargos_id_seq'::regclass);
 8   ALTER TABLE public.cargos ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    205    206    206            �
           2604    24809 
   cidades id    DEFAULT     h   ALTER TABLE ONLY public.cidades ALTER COLUMN id SET DEFAULT nextval('public.cidades_id_seq'::regclass);
 9   ALTER TABLE public.cidades ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    198    198            �
           2604    24874    empresas id    DEFAULT     j   ALTER TABLE ONLY public.empresas ALTER COLUMN id SET DEFAULT nextval('public.empresas_id_seq'::regclass);
 :   ALTER TABLE public.empresas ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    207    208    208            �
           2604    24835    escolaridades id    DEFAULT     t   ALTER TABLE ONLY public.escolaridades ALTER COLUMN id SET DEFAULT nextval('public.escolaridades_id_seq'::regclass);
 ?   ALTER TABLE public.escolaridades ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    201    202    202            �
           2604    24846 
   pessoas id    DEFAULT     h   ALTER TABLE ONLY public.pessoas ALTER COLUMN id SET DEFAULT nextval('public.pessoas_id_seq'::regclass);
 9   ALTER TABLE public.pessoas ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    204    203    204            �
           2604    24902    pessoas_vagas id    DEFAULT     t   ALTER TABLE ONLY public.pessoas_vagas ALTER COLUMN id SET DEFAULT nextval('public.pessoas_vagas_id_seq'::regclass);
 ?   ALTER TABLE public.pessoas_vagas ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    212    211    212            �
           2604    24920    usuarios id    DEFAULT     j   ALTER TABLE ONLY public.usuarios ALTER COLUMN id SET DEFAULT nextval('public.usuarios_id_seq'::regclass);
 :   ALTER TABLE public.usuarios ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    213    214    214            X          0    24819    bairros 
   TABLE DATA               E   COPY public.bairros (id, nome, id_cidade, data_exclusao) FROM stdin;
    public       postgres    false    200   �V       b          0    24881    cargo_empresa 
   TABLE DATA               P   COPY public.cargo_empresa (id, id_cargo, id_empresa, data_exclusao) FROM stdin;
    public       postgres    false    210   fW       ^          0    24863    cargos 
   TABLE DATA               9   COPY public.cargos (id, nome, data_exclusao) FROM stdin;
    public       postgres    false    206   �W       V          0    24806    cidades 
   TABLE DATA               F   COPY public.cidades (id, nome, uf_estados, data_exclusao) FROM stdin;
    public       postgres    false    198   �W       `          0    24871    empresas 
   TABLE DATA               A   COPY public.empresas (id, nome, cnpj, data_exclusao) FROM stdin;
    public       postgres    false    208   5X       Z          0    24832    escolaridades 
   TABLE DATA               H   COPY public.escolaridades (id, escolaridade, data_exclusao) FROM stdin;
    public       postgres    false    202   �X       T          0    24799    estados 
   TABLE DATA               +   COPY public.estados (uf, nome) FROM stdin;
    public       postgres    false    196   �X       \          0    24843    pessoas 
   TABLE DATA               v   COPY public.pessoas (id, nome, cpf, data_nascimento, telefone, id_bairro, id_escolaridade, data_exclusao) FROM stdin;
    public       postgres    false    204   �Y       d          0    24899    pessoas_vagas 
   TABLE DATA               W   COPY public.pessoas_vagas (id, id_pessoa, id_cargo_empresa, data_exclusao) FROM stdin;
    public       postgres    false    212   	Z       f          0    24917    usuarios 
   TABLE DATA               A   COPY public.usuarios (id, login, nome, senha, nivel) FROM stdin;
    public       postgres    false    214   &Z       v           0    0    bairros_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.bairros_id_seq', 28, true);
            public       postgres    false    199            w           0    0    cargo_empresa_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.cargo_empresa_id_seq', 1, false);
            public       postgres    false    209            x           0    0    cargos_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cargos_id_seq', 1, false);
            public       postgres    false    205            y           0    0    cidades_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cidades_id_seq', 11, true);
            public       postgres    false    197            z           0    0    empresas_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.empresas_id_seq', 13, true);
            public       postgres    false    207            {           0    0    escolaridades_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.escolaridades_id_seq', 1, false);
            public       postgres    false    201            |           0    0    pessoas_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.pessoas_id_seq', 1, false);
            public       postgres    false    203            }           0    0    pessoas_vagas_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.pessoas_vagas_id_seq', 1, false);
            public       postgres    false    211            ~           0    0    usuarios_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuarios_id_seq', 3, true);
            public       postgres    false    213            �
           2606    24824    bairros bairros_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.bairros
    ADD CONSTRAINT bairros_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.bairros DROP CONSTRAINT bairros_pkey;
       public         postgres    false    200            �
           2606    24886     cargo_empresa cargo_empresa_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.cargo_empresa
    ADD CONSTRAINT cargo_empresa_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.cargo_empresa DROP CONSTRAINT cargo_empresa_pkey;
       public         postgres    false    210            �
           2606    24868    cargos cargos_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.cargos
    ADD CONSTRAINT cargos_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.cargos DROP CONSTRAINT cargos_pkey;
       public         postgres    false    206            �
           2606    24811    cidades cidades_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cidades
    ADD CONSTRAINT cidades_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cidades DROP CONSTRAINT cidades_pkey;
       public         postgres    false    198            �
           2606    24876    empresas empresas_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.empresas
    ADD CONSTRAINT empresas_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.empresas DROP CONSTRAINT empresas_pkey;
       public         postgres    false    208            �
           2606    24840     escolaridades escolaridades_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.escolaridades
    ADD CONSTRAINT escolaridades_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.escolaridades DROP CONSTRAINT escolaridades_pkey;
       public         postgres    false    202            �
           2606    24803    estados estados_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.estados
    ADD CONSTRAINT estados_pkey PRIMARY KEY (uf);
 >   ALTER TABLE ONLY public.estados DROP CONSTRAINT estados_pkey;
       public         postgres    false    196            �
           2606    24848    pessoas pessoas_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT pessoas_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT pessoas_pkey;
       public         postgres    false    204            �
           2606    24904     pessoas_vagas pessoas_vagas_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.pessoas_vagas
    ADD CONSTRAINT pessoas_vagas_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.pessoas_vagas DROP CONSTRAINT pessoas_vagas_pkey;
       public         postgres    false    212            �
           2606    24878    empresas un_cnpj 
   CONSTRAINT     K   ALTER TABLE ONLY public.empresas
    ADD CONSTRAINT un_cnpj UNIQUE (cnpj);
 :   ALTER TABLE ONLY public.empresas DROP CONSTRAINT un_cnpj;
       public         postgres    false    208            �
           2606    24850    pessoas un_cpf 
   CONSTRAINT     H   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT un_cpf UNIQUE (cpf);
 8   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT un_cpf;
       public         postgres    false    204            �
           2606    24922    usuarios usuarios_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public         postgres    false    214            �
           2606    24851    pessoas fk_bairro    FK CONSTRAINT     t   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT fk_bairro FOREIGN KEY (id_bairro) REFERENCES public.bairros(id);
 ;   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT fk_bairro;
       public       postgres    false    2752    204    200            �
           2606    24887    cargo_empresa fk_cargo    FK CONSTRAINT     w   ALTER TABLE ONLY public.cargo_empresa
    ADD CONSTRAINT fk_cargo FOREIGN KEY (id_cargo) REFERENCES public.cargos(id);
 @   ALTER TABLE ONLY public.cargo_empresa DROP CONSTRAINT fk_cargo;
       public       postgres    false    210    206    2760            �
           2606    24910    pessoas_vagas fk_cargo_empresa    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoas_vagas
    ADD CONSTRAINT fk_cargo_empresa FOREIGN KEY (id_cargo_empresa) REFERENCES public.cargo_empresa(id);
 H   ALTER TABLE ONLY public.pessoas_vagas DROP CONSTRAINT fk_cargo_empresa;
       public       postgres    false    2766    212    210            �
           2606    24825    bairros fk_cidade    FK CONSTRAINT     t   ALTER TABLE ONLY public.bairros
    ADD CONSTRAINT fk_cidade FOREIGN KEY (id_cidade) REFERENCES public.cidades(id);
 ;   ALTER TABLE ONLY public.bairros DROP CONSTRAINT fk_cidade;
       public       postgres    false    2750    200    198            �
           2606    24892    cargo_empresa fk_empresa    FK CONSTRAINT     }   ALTER TABLE ONLY public.cargo_empresa
    ADD CONSTRAINT fk_empresa FOREIGN KEY (id_empresa) REFERENCES public.empresas(id);
 B   ALTER TABLE ONLY public.cargo_empresa DROP CONSTRAINT fk_empresa;
       public       postgres    false    2762    210    208            �
           2606    24856    pessoas fk_escolaridade    FK CONSTRAINT     �   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT fk_escolaridade FOREIGN KEY (id_escolaridade) REFERENCES public.escolaridades(id);
 A   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT fk_escolaridade;
       public       postgres    false    202    204    2754            �
           2606    24812    cidades fk_estados    FK CONSTRAINT     v   ALTER TABLE ONLY public.cidades
    ADD CONSTRAINT fk_estados FOREIGN KEY (uf_estados) REFERENCES public.estados(uf);
 <   ALTER TABLE ONLY public.cidades DROP CONSTRAINT fk_estados;
       public       postgres    false    2748    196    198            �
           2606    24905    pessoas_vagas fk_pessoa    FK CONSTRAINT     z   ALTER TABLE ONLY public.pessoas_vagas
    ADD CONSTRAINT fk_pessoa FOREIGN KEY (id_pessoa) REFERENCES public.pessoas(id);
 A   ALTER TABLE ONLY public.pessoas_vagas DROP CONSTRAINT fk_pessoa;
       public       postgres    false    212    2756    204            X   �   x�mO1�0�7��8�%�)+}͉)R�8�O�?����vow�q����x�z/`47�qyJp�@����"�Ș ���lAe�V1�.>��\?8ͧտb���f�6�e3�+�aR'�f�/��[���%�J����ik_�WJ} ��D�      b      x������ � �      ^      x������ � �      V   �   x�3��I�JML��
���2�>�8_! �4'�38 $d������������YT�6�t�KN�+A����/KTp*J-N�L�
p:%g� E\�8�-ut�,�9�3S�����B���qqq �X)P      `   p   x�Uͽ�@�9y�";�\�uc�	�00ti���Á����vȸ^o�E<P=� �#:Ku�?�Ej�'Ji |L��c���rkh��/*�o�����3��[8�T�rI#      Z      x������ � �      T   
  x�]O9n�0�w_���L1"� U�YۄM@�
���7Fju�?��� ���13�U[���@��ʀi*/T톾8�zPp�g �5Ԟ���'8�<�0su��'P;�y*�.:�3c�Aá�2�
ZJ�囱��R�8g��/��r��6����2f�6�PY����8n��S����;�@KYў���3E���J#w��݅��Ѻ��v`9��O���
�0#��a�HUM3%ɉ΀�r��e`t�O�0y�;��&�!f�|C�_�P}[      \      x������ � �      d      x������ � �      f   0   x�3�tL����,-��442�t�2���/�M��t�K�q��qqq ��
0     