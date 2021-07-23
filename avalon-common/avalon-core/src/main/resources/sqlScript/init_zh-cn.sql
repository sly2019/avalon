--
-- Table structure for table `product_node`
--

CREATE TABLE IF NOT EXISTS `rbac_resource` (
    `id` varchar(64) NOT NULL COMMENT 'id',
    `pid` varchar(64) DEFAULT NULL COMMENT 'pid',
    `name` varchar(100) DEFAULT NULL COMMENT '名称',
    `uri` varchar(255) DEFAULT NULL COMMENT '资源uri',
    `description` mediumtext DEFAULT NULL COMMENT '描述',
    `sequence` double DEFAULT NULL COMMENT '顺序',
    `created_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    `updated_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产线节点';

