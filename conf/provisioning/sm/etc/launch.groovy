tryExec "$__dir/system_properties"

exec "$__dir/preboot/**"
exec "$__dir/boot/**"
exec "$__dir/after/**"