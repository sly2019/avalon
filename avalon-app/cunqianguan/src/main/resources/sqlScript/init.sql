
--
-- Table structure for table `demo_docker_test`
--
CREATE TABLE IF NOT EXISTS `demo_docker_test`(
    `id` varchar(50) NOT NULL COMMENT 'ID',
    `name` varchar(100) DEFAULT NULL COMMENT '名称',
    `create_time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='test';
