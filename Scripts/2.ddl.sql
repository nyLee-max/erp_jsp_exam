-- �� ��Ű��
CREATE SCHEMA `erp_jsp_exam`;

-- �μ�
CREATE TABLE `erp_jsp_exam`.`DEPARTMENT` (
	`DEPT_NO`   INTEGER     NOT NULL COMMENT '�μ���ȣ', -- �μ���ȣ
	`DEPT_NAME` VARCHAR(20) NULL     COMMENT '�μ���', -- �μ���
	`FLOOR`     INTEGER     NULL     COMMENT '��ġ' -- ��ġ
)
COMMENT '�μ�';

-- �μ�
ALTER TABLE `erp_jsp_exam`.`DEPARTMENT`
	ADD CONSTRAINT `PK_DEPARTMENT` -- �μ� �⺻Ű
		PRIMARY KEY (
			`DEPT_NO` -- �μ���ȣ
		);

-- ���
CREATE TABLE `erp_jsp_exam`.`EMPLOYEE` (
	`EMP_NO`   INTEGER     NOT NULL COMMENT '�����ȣ', -- �����ȣ
	`EMP_NAME` VARCHAR(20) NULL     COMMENT '�����', -- �����
	`TNO`      INTEGER     NULL     COMMENT '��å', -- ��å
	`MANAGER`  INTEGER     NULL     COMMENT '���ӻ��', -- ���ӻ��
	`SALARY`   INTEGER     NULL     COMMENT '�޿�', -- �޿�
	`DNO`      INTEGER     NULL     COMMENT '�μ�', -- �μ�
	`HIREDATE` DATE        NULL     COMMENT '�Ի���' -- �Ի���
)
COMMENT '���';

-- ���
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `PK_EMPLOYEE` -- ��� �⺻Ű
		PRIMARY KEY (
			`EMP_NO` -- �����ȣ
		);

-- ��å
CREATE TABLE `erp_jsp_exam`.`TITLE` (
	`TITLE_NO`   INTEGER     NOT NULL COMMENT '��å��ȣ', -- ��å��ȣ
	`TITLE_NAME` VARCHAR(10) NULL     COMMENT '��å��' -- ��å��
)
COMMENT '��å';

-- ��å
ALTER TABLE `erp_jsp_exam`.`TITLE`
	ADD CONSTRAINT `PK_TITLE` -- ��å �⺻Ű
		PRIMARY KEY (
			`TITLE_NO` -- ��å��ȣ
		);

-- ���
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `FK_TITLE_TO_EMPLOYEE` -- ��å -> ���
		FOREIGN KEY (
			`TNO` -- ��å
		)
		REFERENCES `erp_jsp_exam`.`TITLE` ( -- ��å
			`TITLE_NO` -- ��å��ȣ
		);

-- ���
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `FK_EMPLOYEE_TO_EMPLOYEE` -- ��� -> ���
		FOREIGN KEY (
			`MANAGER` -- ���ӻ��
		)
		REFERENCES `erp_jsp_exam`.`EMPLOYEE` ( -- ���
			`EMP_NO` -- �����ȣ
		);

-- ���
ALTER TABLE `erp_jsp_exam`.`EMPLOYEE`
	ADD CONSTRAINT `FK_DEPARTMENT_TO_EMPLOYEE` -- �μ� -> ���
		FOREIGN KEY (
			`DNO` -- �μ�
		)
		REFERENCES `erp_jsp_exam`.`DEPARTMENT` ( -- �μ�
			`DEPT_NO` -- �μ���ȣ
		);