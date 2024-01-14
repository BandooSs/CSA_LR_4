<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Selected Team Information</h2>
                <table border="1">
                    <tr>
                        <th>id_team</th>
                        <th>first_name</th>
                        <th>last_name</th>
                    </tr>
                    <xsl:for-each select="ArrayList/item">
                        <tr>
                            <td><xsl:value-of select="id_team"/></td>
                            <td><xsl:value-of select="first_name"/></td>
                            <td><xsl:value-of select="city_name"/></td>
                        </tr>

                    </xsl:for-each>
                </table>




            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>