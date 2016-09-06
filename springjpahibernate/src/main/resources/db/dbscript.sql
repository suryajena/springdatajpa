CREATE TABLE `testuser` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `tenant_name` varchar(60) NOT NULL,
   `tenant_code` varchar(60) NOT NULL,
  `employees_number` int(6) NOT NULL,
  `active` tinyint(1) DEFAULT NULL,
  createdBy varchar(60) ,
  createdDate timestamp,
  lastModifiedBy varchar(60) ,
  lastModifiedDate timestamp,
  
  PRIMARY KEY (`id`)
)