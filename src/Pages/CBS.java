package Pages;

public class CBS {
	public String sRequestByOrder(String sOrder) {
		sOrder = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v1=\"http://www.personal.com.ar/Common/RequestMessageHeader/v1.0\" xmlns:v11=\"http://www.personal.com.ar/ESB/NotificarPago/v1.0\">\r\n"
				+ "\r\n   <soapenv:Header>\r\n"
				+ "\r\n      <v1:requestHeader>\r\n"
				+ "\r\n         <v1:consumer code=\"IVR\" channel=\"IVR\" additionalData=\"\">\r\n"
				+ "\r\n            <v1:userID>jack</v1:userID>\r\n"
				+ "\r\n            <v1:credentials>\r\n"
				+ "\r\n               <!--You have a CHOICE of the next 2 items at this level-->\r\n"
				+ "\r\n               <!--v1:userCertificate>?</v1:userCertificate-->\r\n"
				+ "\r\n               <v1:userPassword>jack</v1:userPassword>\r\n"
				+ "\r\n            </v1:credentials>\r\n"
				+ "\r\n         </v1:consumer>\r\n"
				+ "\r\n         <v1:message messageId=\"\" consumerMessageId=\"\">\r\n"
				+ "\r\n            <!--Optional:-->\r\n"
				+ "\r\n            <!--v1:timestamp>?</v1:timestamp-->\r\n"
				+ "\r\n         </v1:message>\r\n"
				+ "\r\n      </v1:requestHeader>\r\n"
				+ "\r\n   </soapenv:Header>\r\n"
				+ "\r\n   <soapenv:Body>\r\n"
				+ "\r\n      <v11:NotificarPagoRequest>\r\n"
				+ "\r\n         <v11:salesOrderId>" + sOrder;
		
		sOrder+= "</v11:salesOrderId>\r\n"
				+ "\r\n         <v11:status>payment succeed</v11:status>\r\n"
				+ "\r\n         <v11:statusInvoice>invoice succeed</v11:statusInvoice>\r\n"
				+ "\r\n      </v11:NotificarPagoRequest>\r\n"
				+ "\r\n   </soapenv:Body>\r\n"
				+ "\r\n</soapenv:Envelope>";
		return sOrder;
	}
	
	public String sRequest(String sPaymentSerialNo, String sPaymentChannelID, String sAccountKey, String sPaymentMethod, String sAmount, String sInvoiceno) {
		String sRequest = "";
		sRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ars=\"http://www.huawei.com/bme/cbsinterface/arservices\" xmlns:cbs=\"http://www.huawei.com/bme/cbsinterface/cbscommon\" xmlns:arc=\"http://cbs.huawei.com/ar/wsservice/arcommon\">\r\n"
				+ "    <soapenv:Header/>\r\n"
				+ "\r\n    <soapenv:Body>\r\n"
				+ "\r\n        <ars:PaymentRequestMsg>\r\n"
				+ "\r\n            <RequestHeader>\r\n"
				+ "      	       		<cbs:Version>5.5</cbs:Version>\r\n"
				+ "      	       		<cbs:BusinessCode>Charge2AR</cbs:BusinessCode>\r\n"
				+ "       	       		<cbs:MessageSeq>20180809151425662";
		
		sRequest+="</cbs:MessageSeq>\r\n"
				+ "       	       		<cbs:OwnershipInfo>\r\n"
				+ "       	         		<cbs:BEID>10101</cbs:BEID>\r\n"
				+ "       	         		<cbs:BRID>101</cbs:BRID>\r\n"
				+ "         	   		</cbs:OwnershipInfo>\r\n"
				+ "             		<cbs:AccessSecurity>\r\n"
				+ "     	           		<cbs:LoginSystemCode>117</cbs:LoginSystemCode>\r\n"
				+ "         	       		<cbs:Password>jW6lRxU4leO5Xev+SISea/Ie7Dp5wDPgfGR9MNVDJRo=</cbs:Password>\r\n"
				+ "             	   		<cbs:RemoteIP>10.75.197.142</cbs:RemoteIP>\r\n"
				+ "       	      		</cbs:AccessSecurity>\r\n"
				+ "        	       		<cbs:OperatorInfo>\r\n"
				+ "        	        		<cbs:OperatorID>101</cbs:OperatorID>\r\n"
				+ "        	        		<cbs:ChannelID>1</cbs:ChannelID>\r\n"
				+ "        	       		</cbs:OperatorInfo>\r\n"
				+ "        	        	<cbs:AccessMode>A</cbs:AccessMode>\r\n"
				+ "        	        	<cbs:MsgLanguageCode>2002</cbs:MsgLanguageCode>\r\n"
				+ "        	        	<cbs:TimeFormat>\r\n"
				+ "        	        		<cbs:TimeType>1</cbs:TimeType>\r\n"
				+ "        	        		<cbs:TimeZoneID>8</cbs:TimeZoneID>\r\n"
				+ "        	       		</cbs:TimeFormat>\r\n"
				+ "        	        	<cbs:AdditionalProperty>\r\n"
				+ "        	        		<cbs:Code>108</cbs:Code>\r\n"
				+ "        	        		<cbs:Value>109</cbs:Value>\r\n"
				+ "        	        	</cbs:AdditionalProperty>\r\n"
				+ "     	      </RequestHeader>\r\n"
				+ "            <PaymentRequest>\r\n"
				+ "                <ars:PaymentSerialNo>" + sPaymentSerialNo;
		
		sRequest+= "</ars:PaymentSerialNo>\r\n"
				+ "                <ars:PaymentChannelID>" + sPaymentChannelID;
		
		sRequest+= "</ars:PaymentChannelID>\r\n"
				+ "                <ars:OpType>1</ars:OpType>\r\n"
				+ "                <ars:PaymentObj>\r\n"
				+ "                    <ars:AcctAccessCode>\r\n"
				+ "                        <arc:AccountKey>" + sAccountKey;
		
		sRequest+= "</arc:AccountKey>\r\n"
				+ "                    </ars:AcctAccessCode>\r\n"
				+ "                </ars:PaymentObj>\r\n"
				+ "                <ars:PaymentInfo>\r\n"
				+ "                    <ars:CashPayment>\r\n"
				+ "                        <ars:PaymentMethod>" + sPaymentMethod;
		
		sRequest+= "</ars:PaymentMethod>\r\n"
				+ "                        <ars:Amount>" + sAmount;
		
		sRequest+= "</ars:Amount>\r\n"
				+ "                        <ars:ApplyList>\r\n"
				+ "                            <ars:Invoiceno>" + sInvoiceno;
		
		sRequest+= "</ars:Invoiceno>                    \r\n"
				+ "                        </ars:ApplyList>\r\n"
				+ "                    </ars:CashPayment>\r\n"
				+ "                </ars:PaymentInfo>\r\n"
				+ "            </PaymentRequest>\r\n"
				+ "        </ars:PaymentRequestMsg>\r\n"
				+ "    </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		
		return sRequest;
	}
	
	public String sCBS_Request_ServicioWeb_Validador(String sResponse) {
		String sAssert = "false";
		
		if (sResponse.equalsIgnoreCase("0OK")) {
			sAssert = "true";
		}
		else {
			sAssert = sResponse;
		}
		
		return sAssert;
	}
	
	public String sCBS_Request_Validador(String sResponse) {
		String sAssert = "false";
		
		if (sResponse.contains("Operation successfully")) {
			sAssert = "true";
		}
		else {
			sAssert = sResponse;
		}
		
		return sAssert;
	}
}