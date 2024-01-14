<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>All Teams</h2>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>City Name</th>
                        <th>Delete</th>
                    </tr>
                    <xsl:for-each select="ArrayList/item">
                        <tr>
                            <td><a href="/teams/{id_team}"><xsl:value-of select="id_team"/></a></td>
                            <td><xsl:value-of select="first_name"/></td>
                            <td><xsl:value-of select="city_name"/></td>
<!--                            <td><a href="/teams/delete/{id_team}" method="DELETE"><xsl:value-of select="id_team"/></a></td>-->
                            <td>
                                <a href="/teams/delete/{id_team}" method="DELETE">Delete</a>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>

                <h1>Add Team</h1>
                <form action="/teams/create" method="post" enctype="application/x-www-form-urlencoded">
                    <label for="first_name">First Name:</label>
                    <input type="text" id="first_name" name="first_name" required="required"/><br/>

                    <label for="city_name">Last Name:</label>
                    <input type="text" id="city_name" name="city_name" required="required"/><br/>

                    <input type="submit" value="Submit"/>
                </form>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>