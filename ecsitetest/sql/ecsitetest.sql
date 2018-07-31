set names utf8;
set foreign_key_checks=0;

drop database if exists ecsitetest;
create database if not exists ecsitetest;

use ecsitetest;

create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
sex tinyint not null default 0 comment "姓別",
email varchar(32) not null comment "メールアドレス",
status tinyint not null default 0 comment "ステータス",
logined tinyint not null default 0 comment "ログインフラグ",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
)
default charset=utf8
comment="会員情報"
;
insert into user_info values
(1,"guest","guest","ゲスト","ユーザー","げすと","ゆーざー",0,"guest@yahoo.co.jp",0,0,now(),now()),
(2,"admin","admin","管理者","ユーザー","かんりしゃ","ゆーざー",0,"admin@gmail.com",1,0,now(),now());

create table product_info(
id int primary key not null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(100) unique not null comment "商品名",
product_name_kana varchar(100) not null comment "商品名かな",
product_description varchar(255) not null comment "商品詳細",
category_id int not null not null comment "カテゴリID",
price int comment "価格",
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名",
release_date datetime not null comment "発売年月",
release_company varchar(50) comment "発売会社",
status tinyint not null default 0 comment "ステータス",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日",
foreign key(category_id) references m_category(category_id)
)
default charset=utf8
comment="商品情報"
;
insert into product_info values
( 1, 1,"商品１","しょうひん１","商品詳細",2,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 2, 2,"商品２","しょうひん２","商品詳細",2,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 3, 3,"商品３","しょうひん３","商品詳細",2,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 4, 4,"商品４","しょうひん４","商品詳細",3,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 5, 5,"商品５","しょうひん５","商品詳細",3,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 6, 6,"商品６","しょうひん６","商品詳細",3,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 7, 7,"商品７","しょうひん７","商品詳細",4,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 8, 8,"商品８","しょうひん８","商品詳細",4,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 9, 9,"商品９","しょうひん９","商品詳細",4,100,"./images","sample.jpg",now(),"発売会社",0,now(),now()),
( 10, 10,"商品１０","しょうひん１０","商品詳細",4,100,"./images","sample.jpg",now(),"発売会社",0,now(),now());

create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
temp_user_id varchar(16) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="カート情報"
;

create table purchase_history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
destination_id int not null comment "宛先情報ID",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日",
foreign key(user_id) references user_info(user_id),
foreign key(product_id) references product_info(product_id)
)
default charset=utf8
comment="購入履歴情報"
;

create table destination_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
email varchar(32) not null comment "メールアドレス",
tel_number varchar(13) not null comment "電話番号",
user_address varchar(50) not null comment "住所",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
)
default charset=utf8
comment="宛先情報"
;
insert into destination_info values
(1,"guest","ゲスト","ユーザー","げすと","ゆーざー","guest@yahoo.co.jp","080-1234-5678","東京都新宿区高田馬場４－３０－４",now(),"0000-00-00 00:00:00");

create table m_category(
id int primary key not null comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="カテゴリマスタ"
;
insert into m_category values
(1,1,"全てのカテゴリー","全ての商品",now(), null),
(2,2,"カテゴリーA","商品A",now(),null),
(3,3,"カテゴリーB","商品B",now(),null),
(4,4,"カテゴリーC","商品C",now(),null);