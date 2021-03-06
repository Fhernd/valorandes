/*RFC1_FILTRO_TIPO VALOR */
SELECT * FROM VALOR V WHERE V.FK_ID_TIPO_VALOR='INGRESADO_USUARIO';

/*RFC1_FILTRO_TIPO RENTABILIDAD */
SELECT * FROM VALOR V WHERE V.FK_ID_RENTABILIDAD='INGRESADO_USUARIO';

/*RFC1_FILTRO_NEGOCIACIÓN 1=SI; 0: NO */
SELECT * FROM VALOR V WHERE V.NEGOCIACION='INGRESADO_USUARIO';

/*RFC1_FILTRO_NEGOCIACIÓN 1=SI; 0: NO */
SELECT * FROM VALOR V WHERE V.NEGOCIACION='INGRESADO_USUARIO';

/*RFC1_FILTRO_EMISOR  */
SELECT * FROM VALOR V WHERE V.FK_EMISOR='ID_EMISOR_INGRESADO';

/*RFC1_FILTRO_INTERMEDIARIO */
SELECT * FROM VALOR V WHERE V.FK_INTERMEDIARIO='ID_INTERMEDIARIO_INGRESADO';

/*RFC1_FILTRO_INVERSIONISTA */
SELECT VAL.* FROM
((REGISTROOPERACION REG INNER JOIN SOLICITUDOPERACION SOL ON REG.FK_ID_SOLICITUD=SOL.ID_SOLICITUD)INNER JOIN INVERSIONISTA INVER ON SOL.FK_ID_INVERSIONISTA=INVER.ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO';


/*RFC2_FILTRO_INVERSIONISTA */
SELECT * FROM
(INVERSIONISTA INVER INNER JOIN SOLICITUDOPERACION SOL ON INVER.ID_INVERSIONISTA= SOL.FK_ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO';


/*RFC2_FILTRO_INVERSIONISTA_TIPOOPERACION*/
SELECT * FROM
(INVERSIONISTA INVER INNER JOIN SOLICITUDOPERACION SOL ON INVER.ID_INVERSIONISTA= SOL.FK_ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO' AND SOL.FK_ID_TIPO='TIPO_OPERACION_INGRESADO';

/*RFC2_FILTRO_INVERSIONISTA_TIPORENTABILIDAD*/
SELECT * FROM
(INVERSIONISTA INVER INNER JOIN SOLICITUDOPERACION SOL ON INVER.ID_INVERSIONISTA= SOL.FK_ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO' AND VAL.FK_ID_RENTABILIDAD='TIPO_RENTABILIDAD_INGRESADO';

/*RFC2_FILTRO_INVERSIONISTA_TIPORENTABILIDAD_TIPOoPERACION*/
SELECT * FROM
(INVERSIONISTA INVER INNER JOIN SOLICITUDOPERACION SOL ON INVER.ID_INVERSIONISTA= SOL.FK_ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO' AND VAL.FK_ID_RENTABILIDAD='TIPO_RENTABILIDAD_INGRESADO' AND SOL.FK_ID_TIPO='TIPO_OPERACION_INGRESADO';

/*RFC2_FILTRO_INVERSIONISTA_RANGO_FECHAS*/
SELECT * FROM
(INVERSIONISTA INVER INNER JOIN SOLICITUDOPERACION SOL ON INVER.ID_INVERSIONISTA= SOL.FK_ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO' AND SOL.FECHA_SOLICITUD BETWEEN TO_DATE('09/17/2014', 'MM/DD/YYYY') AND TO_DATE('09/27/2014', 'MM/DD/YYYY');

/*RFC2_FILTRO_INVERSIONISTA_MONTO_MINIMO */
SELECT * FROM
(INVERSIONISTA INVER INNER JOIN SOLICITUDOPERACION SOL ON INVER.ID_INVERSIONISTA= SOL.FK_ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO' AND SOL.MONTO_OPERACION>'MONTO_MINIMO_INGRESADO';

/*RFC2_FILTRO_INVERSIONISTA_MONTO_MAXIMO */
SELECT * FROM
(INVERSIONISTA INVER INNER JOIN SOLICITUDOPERACION SOL ON INVER.ID_INVERSIONISTA= SOL.FK_ID_INVERSIONISTA) INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR
WHERE INVER.ID_INVERSIONISTA='ID_INVERSIONISTA_INGRESADO' AND SOL.MONTO_OPERACION<'MONTO_MAXIMO_INGRESADO';

/*RFC2_FILTRO_EMISOR */
SELECT * FROM
EMISOR EMI INNER JOIN (SOLICITUDOPERACION SOL  INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR)ON EMI.NIT=VAL.FK_EMISOR
WHERE EMI.NIT='ID_EMISOR_INGRESADO';

/*RFC2_FILTRO_EMISOR_TIPOOPERACION */
SELECT * FROM
EMISOR EMI INNER JOIN (SOLICITUDOPERACION SOL  INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR)ON EMI.NIT=VAL.FK_EMISOR
WHERE EMI.NIT='ID_EMISOR_INGRESADO' AND SOL.FK_ID_TIPO='TIPO_OPERACION_INGRESADO' ;

/*RFC2_FILTRO_EMISOR_TIPORENTABILIDAD*/
SELECT * FROM
EMISOR EMI INNER JOIN (SOLICITUDOPERACION SOL  INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR)ON EMI.NIT=VAL.FK_EMISOR
WHERE EMI.NIT='ID_EMISOR_INGRESADO' AND VAL.FK_ID_RENTABILIDAD='TIPO_RENTABILIDAD_INGRESADO' ;

/*RFC2_FILTRO_EMISOR_TIPORENTABILIDAD_TIPOOPERACION */
SELECT * FROM
EMISOR EMI INNER JOIN (SOLICITUDOPERACION SOL  INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR)ON EMI.NIT=VAL.FK_EMISOR
WHERE EMI.NIT='ID_EMISOR_INGRESADO' AND VAL.FK_ID_RENTABILIDAD='TIPO_RENTABILIDAD_INGRESADO' AND SOL.FK_ID_TIPO='TIPO_OPERACION_INGRESADO' ;

/*RFC2_FILTRO_EMISOR_RANGO_FECHA */
SELECT * FROM
EMISOR EMI INNER JOIN (SOLICITUDOPERACION SOL  INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR)ON EMI.NIT=VAL.FK_EMISOR
WHERE EMI.NIT='ID_EMISOR_INGRESADO' AND SOL.FECHA_SOLICITUD BETWEEN TO_DATE('09/17/2014', 'MM/DD/YYYY') AND TO_DATE('09/27/2014', 'MM/DD/YYYY');

/*RFC2_FILTRO_EMISOR_MONTO_MAXIMO */
SELECT * FROM
EMISOR EMI INNER JOIN (SOLICITUDOPERACION SOL  INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR)ON EMI.NIT=VAL.FK_EMISOR
WHERE EMI.NIT='ID_EMISOR_INGRESADO' AND SOL.MONTO_OPERACION<'MONTO_MAX_INGRESADO';

/*RFC2_FILTRO_EMISOR_MONTO_MINIMO */
SELECT * FROM
EMISOR EMI INNER JOIN (SOLICITUDOPERACION SOL  INNER JOIN VALOR VAL ON SOL.FK_ID_VALOR=VAL.ID_VALOR)ON EMI.NIT=VAL.FK_EMISOR
WHERE EMI.NIT='ID_EMISOR_INGRESADO' AND SOL.MONTO_OPERACION>'MONTO_MIN_INGRESADO';