DROP DATABASE IF EXISTS STDM;
CREATE database STDM default character set UTF8;
use STDM;

drop table t_stock;
#基本数据存储表，——应该还要设置唯一约束，防止相同数据的重复导入
create table `t_stock`(
`id` int(11) not null auto_increment comment '表id',
`currency` varchar(32) comment '交易币种',
`stock_name` varchar(32) comment '证券名称',
`trading_time` date comment '成交日期',
`trading_dcode` varchar(32) comment '系统数据中的日期尾数',
`strike_price` float comment '成交价格',
`strike_Num` float comment '成交数量',
`total_Amount` float comment '发生金额',
`balance` float comment '资金余额',
`contract` varchar(32) comment '合同编号',
`bussiness_name` varchar(32) comment '业务名称',
`fees` float comment '手续费',
`stamp_tax` float comment '印花税',
`transfer_fee` float comment '过户费',
`clearing_fees` float comment '结算费',
`stock_code` varchar(32) comment '证券代码',
`shareholder_code` varchar(32) comment '股东代码',
`flag` int(1) comment '银证标示，银行0，证券1',
PRIMARY KEY  (`id`)s
);
#ALTER TABLE `t_stock` ADD unique UK_STOCK (`trading_time`,`trading_dcode`);

drop table t_bussiness_config;
#业务名称表
create table `t_bussiness_config`(
`id` int(11)  comment '表id',
`bussiness_Name` varchar(32) comment '业务名称',
`bussiness_Code` varchar(32) comment '业务名称编号',
`isBank` int(1) comment '银证标示，银行0，证券1',
PRIMARY KEY(`id`)
);

#以股票账号中的资金为基点，流入为0，流出为1，包括交易，购买为流出1，卖出为流入0
insert into t_bussiness_config values (1,'银行转存','0010',0);
insert into t_bussiness_config values (2,'银行转取','0011',1);
insert into t_bussiness_config values (3,'批量利息归本','0030',0);
insert into t_bussiness_config values (4,'证券买入','0021',1);
insert into t_bussiness_config values (5,'证券卖出','0020',1);
insert into t_bussiness_config values (6,'股息入帐','0040',1);
insert into t_bussiness_config values (7,'红股入帐','0050',0);

