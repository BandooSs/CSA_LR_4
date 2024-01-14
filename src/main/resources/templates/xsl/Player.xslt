<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Player Information</h2>
                <table border="1">
                    <tr>
                        <th>id_player</th>
                        <th>first_name</th>
                        <th>last_name</th>
                        <th>Delete</th>
                    </tr>
                    <xsl:for-each select="ArrayList/item">
                        <tr>
                            <td><xsl:value-of select="id_player"/></td>
                            <td><xsl:value-of select="first_name"/></td>
                            <td><xsl:value-of select="last_name"/></td>
                            <td>
                                <a href="/players/delete/{id_player}" method="DELETE">Delete</a>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>