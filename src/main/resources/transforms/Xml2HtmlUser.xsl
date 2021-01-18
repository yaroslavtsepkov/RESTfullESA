<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <div><a href="/users/xml/">All users</a></div>
                <h1>Тип: <xsl:value-of select="User/type"/></h1>
                <div>№: <xsl:value-of select="User/id"/></div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>