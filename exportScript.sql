alter table Order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table Order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table ACCOUNTS;
drop table Order_Details;
drop table Orders;
drop table Products;
create table ACCOUNTS (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table Order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table Orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table Products (Code varchar(20) not null, Create_Date datetime not null, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table Orders add constraint UKsxhpvsj665kmi4f7jdu9d2791 unique (Order_Num);
alter table Order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references Orders;
alter table Order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references Products;
alter table Order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table Order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table Order_Details;
drop table Orders;
drop table Products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table Order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table Orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table Products (Code varchar(20) not null, Create_Date datetime not null, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table Orders add constraint UKsxhpvsj665kmi4f7jdu9d2791 unique (Order_Num);
alter table Order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references Orders;
alter table Order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references Products;
alter table Order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table Order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table Order_Details;
drop table Orders;
drop table Products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table Order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table Orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table Products (Code varchar(20) not null, Create_Date datetime not null, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table Orders add constraint UKsxhpvsj665kmi4f7jdu9d2791 unique (Order_Num);
alter table Order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references Orders;
alter table Order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references Products;
alter table Order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table Order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table Order_Details;
drop table Orders;
drop table Products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table Order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table Orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table Products (Code varchar(20) not null, Create_Date datetime not null, etatProduct int, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table Orders add constraint UKsxhpvsj665kmi4f7jdu9d2791 unique (Order_Num);
alter table Order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references Orders;
alter table Order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references Products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
drop table Products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table Products (Code varchar(20) not null, Create_Date datetime not null, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references Products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
drop table products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, etatProduct int, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table products (Code varchar(20) not null, Create_Date datetime not null, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
drop table products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table products (Code varchar(20) not null, Create_Date datetime not null, etatProduct int, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
drop table products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table products (Code varchar(20) not null, Create_Date datetime not null, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
drop table products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table products (Code varchar(20) not null, Create_Date datetime not null, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
drop table products;
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
create table products (Code varchar(20) not null, Create_Date datetime not null, etatProduct int, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references products;
drop table products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
create table products (Code varchar(20) not null, Create_Date datetime not null, etatProduct int, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references products;
drop table products;
alter table order_Details drop constraint ORDER_DETAIL_ORD_FK;
alter table order_Details drop constraint ORDER_DETAIL_PROD_FK;
drop table accounts;
drop table order_Details;
drop table orders;
create table products (Code varchar(20) not null, Create_Date datetime not null, etat int, Image text, Name varchar(255) not null, Price double precision not null, primary key (Code));
create table accounts (User_Name varchar(20) not null, Active bit not null, Encryted_Password varchar(128) not null, User_Role varchar(20) not null, primary key (User_Name));
create table order_Details (ID varchar(50) not null, Amount double precision not null, Price double precision not null, Quanity int not null, ORDER_ID varchar(50) not null, PRODUCT_ID varchar(20) not null, primary key (ID));
create table orders (ID varchar(50) not null, Amount double precision not null, Customer_Address varchar(255) not null, Customer_Email varchar(128) not null, Customer_Name varchar(255) not null, Customer_Phone varchar(128) not null, Order_Date datetime not null, Order_Num int not null, primary key (ID));
alter table orders add constraint UK8n31uf3gf4m7igyc5r8cc56q4 unique (Order_Num);
alter table order_Details add constraint ORDER_DETAIL_ORD_FK foreign key (ORDER_ID) references orders;
alter table order_Details add constraint ORDER_DETAIL_PROD_FK foreign key (PRODUCT_ID) references products;
