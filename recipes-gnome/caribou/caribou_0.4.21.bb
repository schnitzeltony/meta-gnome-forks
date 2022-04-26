SUMMARY = "A simplified in-place on-screen keyboard"
LICENSE = "LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=e2aa4f66375a24019b0ff5e99cec40ad"

DEPENDS = " \
    libxml2-native \
    libxslt-native \
    intltool-native \
    glib-2.0-native \
    python3-pygobject-native \
    gtk+ \
    gtk+3 \
    libxklavier \
    python3-pygobject \
    clutter-1.0 \
    libgee \
"

inherit gnomebase gobject-introspection gsettings vala gettext features_check 

REQUIRED_DISTRO_FEATURES = "x11 gobject-introspection-data"

# 0001..0007.. are taken from
# https://src.fedoraproject.org/rpms/caribou/tree/rawhide
SRC_URI += " \
    file://0001-caribou-0.4.20-fix-python-exec.patch \
    file://0002-change_autostart_cinnamon.patch \
    file://0003-fix-style-css.patch \
    file://0004-Fix-compilation-error.patch \
    file://0005-Fix-subkey-popmenu-not-showing-after-being-dismissed.patch \
    file://0006-xadapter.vala-Remove-XkbKeyTypesMask-and-f.patch \
    file://0007-drop_gir_patch.patch \
    file://0008-Add-a-dummy-enable-introspection-our-environment-ass.patch \
"
SRC_URI[archive.sha256sum] = "9c43d9f4bd30f4fea7f780d4e8b14f7589107c52e9cb6bd202bd0d1c2064de55"

FILES:${PN} += " \
    ${datadir}/antler \
    ${datadir}/dbus-1 \
    ${PYTHON_SITEPACKAGES_DIR} \
    ${libdir}/gnome-settings-daemon-3.0 \
    ${libdir}/gtk-2.0/modules \
    ${libdir}/gtk-3.0/modules \
"

