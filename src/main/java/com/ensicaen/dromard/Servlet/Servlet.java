package com.ensicaen.dromard.Servlet;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(request.getParameter("code").equals(request.getParameter("inputCode"))) {
            Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/v3/e7f83aeaafd14cb797f74930d2ec4695"));
            Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println(clientVersion);
            EthGetBalance ethGetBalance = null;
            try {
                ethGetBalance = web3
                        .ethGetBalance(request.getParameter("address"), DefaultBlockParameterName.LATEST)
                        .sendAsync()
                        .get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            assert ethGetBalance != null;
            request.setAttribute("balance", ethGetBalance.getBalance());
            request.getRequestDispatcher("Checked.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Error, wrong check code");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String code = Utils.Utils.randomAlphaNumeric(10);
        request.setAttribute("code", code);
        request.getRequestDispatcher("challenge.jsp").forward(request, response);
    }
}
